package com.yearcon.pointshop.moudles.user.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.user.ShopCustomerRepository;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 积分商城 顾客 service
 *
 * @author itguang
 * @create 2018-01-10 15:19
 **/
@Service
public class ShopCustomerService {

    @Autowired
    ShopCustomerRepository shopCustomerRepository;


    /**
     * 通过 openid 查找顾客信息
     *
     * @param openid
     * @return
     */
    public ShopCustomerEntity findByOpenid(String openid) {
        ShopCustomerEntity shopCustomerEntity = shopCustomerRepository.findByOpenid(openid);
        if (shopCustomerEntity == null) {
            throw new ShopException(ResultEnum.NOT_EXIST);

        }
        return shopCustomerEntity;
    }

    /**
     * 保存顾客信息
     *
     * @param shopCustomerEntity
     */
    public ShopCustomerEntity save(ShopCustomerEntity shopCustomerEntity) {
        ShopCustomerEntity one = shopCustomerRepository.save(shopCustomerEntity);
        if (one==null){
            throw new ShopException(ResultEnum.SAVE_CUSTOMER_FAIL);
        }

        return one;
    }


    public ShopCustomerEntity findOne(String customerId) {
        ShopCustomerEntity customerEntity = shopCustomerRepository.findOne(customerId);

        if (customerEntity == null) {
            throw new ShopException(ResultEnum.NOT_EXIST);

        }

        return customerEntity;

    }


}
