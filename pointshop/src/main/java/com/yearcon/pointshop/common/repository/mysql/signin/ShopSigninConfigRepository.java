package com.yearcon.pointshop.common.repository.mysql.signin;

import com.yearcon.pointshop.moudles.signin.entity.ShopSigninConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author itguang
 * @create 2018-01-15 10:02
 **/
public interface ShopSigninConfigRepository extends JpaRepository<ShopSigninConfigEntity,Integer>{
}
