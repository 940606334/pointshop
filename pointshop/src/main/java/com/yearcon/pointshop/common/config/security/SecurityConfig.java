package com.yearcon.pointshop.common.config.security;

import com.yearcon.pointshop.common.fliter.JWTAuthenticationFilter;
import com.yearcon.pointshop.common.fliter.JWTLoginFilter;
import com.yearcon.pointshop.common.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    /**
     * 允许下面的请求匿名访问
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                //测试hello
                "/user/hello",
                // 注册页面
                "/user/signUp",
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
                "/**/*.html",
                "/js/**",
                "/css/**",
                "/images/**",
                "/**/favicon.ico");
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) {

        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService, bCryptPasswordEncoder));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用 csrf
        http.cors().and().csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //添加过滤器,拦截登陆url
                .addFilterBefore(new JWTLoginFilter("/user/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //添加过滤器,拦截所有需要认证的url,验证token
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }


}
