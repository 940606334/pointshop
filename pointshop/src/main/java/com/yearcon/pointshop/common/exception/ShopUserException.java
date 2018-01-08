package com.yearcon.pointshop.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author itguang
 * @create 2018-01-06 14:31
 **/
public class ShopUserException extends AuthenticationException {
    public ShopUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public ShopUserException(String msg) {
        super(msg);
    }
}
