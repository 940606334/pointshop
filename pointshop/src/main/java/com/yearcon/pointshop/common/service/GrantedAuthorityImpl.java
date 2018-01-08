package com.yearcon.pointshop.common.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author itguang
 * @create 2018-01-06 14:37
 **/
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
