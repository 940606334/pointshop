package com.yearcon.pointshop.common.service;

import com.yearcon.pointshop.common.exception.ShopUserException;
import com.yearcon.pointshop.common.repository.oracle.user.UserRepository;
import com.yearcon.pointshop.moudles.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * @author itguang
 * @create 2018-01-06 14:39
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }

        //可在此设置 用户权限
        List<? extends GrantedAuthority> authorities = new ArrayList<>();


        // 关于 UserDetailsService 和 User 对象之前的文章已经讲过.
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);


    }
}
