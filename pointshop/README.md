# 积分商城重构版

## 1 使用 Swagger2 构建 API文档,文档地址: http://localhost/swagger-ui.html 
线上API文档地址：http://dsjfcrm.yearcon.com/shop/swagger-ui.html

> 测试时注意:因为添加了安全校验,在微信网页授权成功之后,服务端会在响应头中放一个token和在cookie中设置一个token
  以后所有的请求都要在cookie或者请求头中(二者至少选一个)带上这个 token ,否则服务器会返回响应码 403,禁止访问.
  可以在 postman 中方便的进行测试.

## 2 使用 mysql 多数据源(Spring Data Jpa),涉及两个数据库.

> 1.**注意:由于后面把crm表的数据同步到了一个数据库,所以目前项目只用到了一个数据库.即; 192.168.1.241:3306/dsdb**

## 3 增加安全认证,使用jwt和Spring Security(注意和Swagger整合时静态页面的拦截问题)
> 还要注意: 由于登陆使用了微信的网页授权,所以 Spring Security 的登陆就去掉了.
> **由于cookie跨域的问题未解决,所以去掉了安全验证的检验.**

如下:配置了 ` "/**"` ,允许所有请求.

```java
/**
 * 安全配置相关
 *
 * @author itguang
 * @create 2018-01-06 13:52
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 允许下面的请求匿名访问
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(

                // 允许所有请求访问 '/**' ,不再需要token安全校验
                "/**",
                //测试hello
                "/user/hello",
                //微信认证的url
                "/weixin/**",
                // 注册
                "/user/register",
                //发送验证码
                "/user/sendCode/**",
                //swagger的静态页面
                "/webjars/**",
                //swagger api json
                "/v2/api-docs",
                //用来获取支持的动作
                "/swagger-resources/configuration/ui",
                //用来获取api-docs的URI
                "/swagger-resources",
                //安全选项
                "/swagger-resources/configuration/security",
                //swagger首页
                "/swagger-ui.html",
                //以下是标准的web页面目录
                "/*.html",
                "/js/**",
                "/css/**",
                "/images/**",
                "/**/favicon.ico");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用 csrf
        http.cors().and().csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //添加过滤器,拦截所有需要认证的url,验证token
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }


}
```



## 4 使用 SpringBoot 自带的定时任务(或者 quarze )进行crm各店铺的数据同步.

详见： com.yearcon.pointshop.moudles.schedule.service.CrmTask.java 


## 5 使用Spring AOP 记录日志

详见： http://blog.csdn.net/itguangit/article/details/78757782

日志配置详见：logback-spring.xml .


## 上线，部署，查看日志

* 上线：

需要把本项目使用maven 打成一个jar包。

E:\idea\babaio-renren-security-renren-security-boot\积分商城--重构\pointshop> mvn clean package  -Dmaven.test.skip=true

* 部署。

首先使用winscp 把打好的jar包放到服务器的 /usr/local 目录下。

然后运行该jar程序，使用命令：

```
nohup java -jar pointshop.jar --server.port=8082 &
```
server.port=8082 表示使用8082端口，所有输出都在 nohup.out 文件里面。

* 查看日志： 

日志文件在 `/usr/log/` 目录下，以每日的日期命名。遇到线上bug应首先查看日志。


## 跨域问题

由于静态页面与api接口分开部署,所以静态页面使用 ajax 通信是会存在跨域问题,这里设置了服务器段允许跨域,设置如下:

**在Spring Boot 的启动类里添加如下配置即可**

```java
private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	/**
	 * 跨域过滤器
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}
```


## Cookie 问题???

A应用: http://dsjfcrm.yearcon.com:8020/webshop/new/index.html
B应用:http://dsjfcrm.yearcon.com/shop/new/index.html

现在:

A--访问-->B  :B应用在 HttpReponse 中设置了两个 cookie, 分别是: openid=123  , token=456

并设置了cookie的domain和path 分别为:  "dsjfcrm.yearcon.com" 和 "/" 

然后,重点来了:

我在A应用中用ajax 访问 B 应用时,在 request 中为什么没有 我刚才设置的两个 cookie 值