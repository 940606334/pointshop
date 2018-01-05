package com.yearcon.pointshop.common.repository.mysql.test;

import com.yearcon.pointshop.moudles.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author itguang
 * @create 2018-01-05 15:12
 **/

public interface UserRository1 extends JpaRepository<UserEntity,Long>{
}
