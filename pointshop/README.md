# 积分商城重构版


* 使用 Swagger2 构建 API文档,文档地址: http://localhost/swagger-ui.html 

> 测试时注意:因为添加了安全校验,在微信网页授权成功之后,服务端会在响应头中放一个token和在cookie中设置一个token
  以后所有的请求都要在cookie或者请求头中(二者至少选一个)带上这个 token ,否则服务器会返回响应码 403,禁止访问.
  可以在 postman 中方便的进行测试.

* 使用 mysql 多数据源(Spring Data Jpa),涉及两个数据库.

* 增加安全认证,使用jwt和Spring Security(注意和Swagger整合时静态页面的拦截问题)
> 还要注意: 由于登陆使用了微信的网页授权,所以 Spring Security 的登陆就去掉了.

* 使用 SpringBoot 自带的定时任务(或者 quarze )进行crm各店铺的数据同步.














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