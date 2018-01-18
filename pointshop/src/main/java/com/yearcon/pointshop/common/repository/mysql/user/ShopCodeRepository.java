package com.yearcon.pointshop.common.repository.mysql.user;

import com.yearcon.pointshop.moudles.user.entity.ShopCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author itguang
 * @create 2018-01-17 16:21
 **/
public interface ShopCodeRepository extends JpaRepository<ShopCodeEntity,Integer>{


    ShopCodeEntity findOneByPhone(String phone);

}
