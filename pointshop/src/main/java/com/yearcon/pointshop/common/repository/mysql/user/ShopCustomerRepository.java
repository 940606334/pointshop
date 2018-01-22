package com.yearcon.pointshop.common.repository.mysql.user;

import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-10 15:25
 **/
public interface ShopCustomerRepository extends JpaRepository<ShopCustomerEntity, String> {

    /**
     * 通过openid 查找 顾客基本信息
     *
     * @param openid
     * @return
     */
    ShopCustomerEntity findByOpenid(String openid);





}
