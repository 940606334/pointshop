package com.yearcon.pointshop.moudles.crm.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.crm.ShopCrmRepository;
import com.yearcon.pointshop.moudles.crm.entity.ShopCrmEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * @author itguang
 * @create 2018-01-12 13:54
 **/
@Service
@Slf4j
public class ShopCrmService {

    @Autowired
    private ShopCrmRepository shopCrmRepository;

    public ShopCrmEntity getByOpenid(String openid){
        ShopCrmEntity shopCrmEntity = shopCrmRepository.findByOpenid(openid);
        if(shopCrmEntity==null){
            throw new ShopException(ResultEnum.NOT_EXIST);
        }
        return shopCrmEntity;
    }


    public ShopCrmEntity findByMobile(String mobile){
        ShopCrmEntity shopCrmEntity = shopCrmRepository.findByMobile(mobile);
        if(shopCrmEntity==null){
            throw new ShopException(ResultEnum.NOT_EXIST);
        }
        return shopCrmEntity;
    }

    public void save(ShopCrmEntity entity){
        ShopCrmEntity save = shopCrmRepository.save(entity);

        if (save==null){
            log.info("【保存ShopCrmEntity失败】");

        }

    }



}
