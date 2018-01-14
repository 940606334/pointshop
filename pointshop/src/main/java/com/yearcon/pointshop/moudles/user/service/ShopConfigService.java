package com.yearcon.pointshop.moudles.user.service;

import com.yearcon.pointshop.common.repository.mysql.shopconfig.ShopConfigRepository;
import com.yearcon.pointshop.moudles.user.entity.ShopConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author itguang
 * @create 2018-01-11 11:10
 **/
@Service
public class ShopConfigService {

    @Autowired
    private ShopConfigRepository shopConfigRepository;

    public ShopConfigEntity findConfig(){
        return shopConfigRepository.findOne("1");
    }



}
