package com.yearcon.pointshop.common.fliter;

import com.yearcon.pointshop.common.config.security.TokenAuthenticationService;
import com.yearcon.pointshop.common.service.GrantedAuthorityImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * 此过滤器拦截 登陆请求 /login
 *
 * @author itguang
 * @create 2018-01-06 13:54
 **/
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


    private AuthenticationManager authenticationManager;

    /**
     *
     * @param url 要拦截的登陆url
     * @param authenticationManager
     */
    public JWTLoginFilter(String url,AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url, "POST"));
        this.authenticationManager = authenticationManager;
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        //得到用户登陆信息,并封装到 Authentication 中,供自定义用户组件使用.
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();


        ArrayList<GrantedAuthorityImpl> authorities = new ArrayList<>();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, authorities);

        //authenticate()接受一个 Authentication 类型参数,返回一个完全经过身份验证的对象，包括证书.
        // 这里并没有对用户名密码进行验证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        return authenticate;
    }


    /**
     * 登陆成功后,此方法会被调用,因此我们可以在次方法中生成token,并返回给客户端
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) {



        TokenAuthenticationService.addAuthenticatiotoHttpHeader(response,authResult);

    }
}
