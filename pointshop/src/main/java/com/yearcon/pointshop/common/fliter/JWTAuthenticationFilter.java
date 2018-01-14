package com.yearcon.pointshop.common.fliter;

import com.yearcon.pointshop.common.config.security.TokenAuthenticationService;
import com.yearcon.pointshop.common.exception.ShopUserException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author itguang
 * @create 2018-01-06 14:30
 **/
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
    }


    /**
     * 从请求头和Cookie中解析出 token
     * 如果存在并合法,就把token中的信息封装到 Authentication 类型的对象中,
     * 最后使用  SecurityContextHolder.getContext().setAuthentication(authentication); 改变或删除当前已经验证的 pricipal
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication(request, response);

        //判断是否有token
        if (authentication == null) {
            chain.doFilter(request, response);
            return;
        }

        //把已验证的 Authentication 设置到 SpringSecurity Context 中
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //放行
        chain.doFilter(request, response);
    }


}

