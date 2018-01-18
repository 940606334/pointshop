package com.yearcon.pointshop.common.config.security;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.utils.CookieUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * token 验证工具类
 *
 * @author itguang
 * @create 2018-01-06 15:01
 **/

public class TokenAuthenticationService {


    /**
     * 过期时间 24 小时 *30
     */
    static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24*30;
    /**
     * JWT 加密密钥
     */
    @Value("${SECRET}")
    static final String SECRET = "www.yearcon.cn";
    /**
     * TOKEN前缀
     */
    static final String TOKEN_PREFIX = "Bearer_";
    /**
     * 存放Token的Header Key
     */
    @Value("${HEADER_STRING}")
   public static final String HEADER_STRING = "token";

    /**
     * 自定义的 playload
     */
    static final String AUTHORITIES = "authorities";


    /**
     * 将jwt token 写入header头部 和 cookie 中
     *
     * @param response
     * @param openid   微信用户凭据 openId
     */
    public static void addToken2Cookie(HttpServletRequest request,HttpServletResponse response, String openid) {


        //生成 jwt
        String token = Jwts.builder()
                .setSubject(openid)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        //把token设置到响应头中去
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

        //把token设置到 cookie 中去,并且设置cookie的过期时间和token的过期时间相同
        CookieUtil.set(request,response, HEADER_STRING, TOKEN_PREFIX + token, new Long(EXPIRATIONTIME / 1000).intValue());
        //为了方便客户段取得 openid ,再把openid 放到 cookie中
        CookieUtil.set(request,response, "openid", openid, new Long(EXPIRATIONTIME / 1000).intValue());



    }

    /**
     * 从请求头和Cookie中解析出 token
     *
     * @param request
     * @param response
     * @return
     */
    public static Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String token = null;
        // 从Header中拿到token
        token = request.getHeader(HEADER_STRING);
        Cookie cookie = CookieUtil.get(request, HEADER_STRING);
        if (cookie != null) {
            token = cookie.getValue();
        }


        if (token == null) {
            return null;
        }


        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        } catch (ExpiredJwtException e) {
//            e.printStackTrace();
            throw new ShopException(ResultEnum.EXPIREDJWTEXCEPTION);
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            throw new ShopException(ResultEnum.SIGNATUREEXCEPTION);
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
            throw new ShopException(ResultEnum.SIGNATUREEXCEPTION);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new ShopException(ResultEnum.SIGNATUREEXCEPTION);
        }


        //得到 openid
        String openid = claims.getSubject();

        //得到过期时间
        Date expiration = claims.getExpiration();

        //判断是否过期
        Date now = new Date();

        if (now.getTime() > expiration.getTime()) {

            throw new ShopException(ResultEnum.EXPIREDJWTEXCEPTION);
        }


        if (openid != null) {
            return new UsernamePasswordAuthenticationToken(openid, null, Collections.emptyList());
        }
        return null;


    }


}
