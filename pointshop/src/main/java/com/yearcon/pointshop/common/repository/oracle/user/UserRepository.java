package com.yearcon.pointshop.common.repository.oracle.user;

import com.yearcon.pointshop.moudles.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author itguang
 * @create 2018-01-06 14:40
 **/
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     *通过用户名查找用户信息
     * @param username
     * @return
     */
    UserEntity findByUsername(String username);

}
