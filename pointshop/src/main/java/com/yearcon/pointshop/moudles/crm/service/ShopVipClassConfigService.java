package com.yearcon.pointshop.moudles.crm.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.shopconfig.ShopVipClassConfigRepository;
import com.yearcon.pointshop.moudles.crm.entity.ShopVipClassConfigEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-20 13:05
 **/
@Service
@Slf4j
public class ShopVipClassConfigService {

    @Autowired
    ShopVipClassConfigRepository shopVipClassConfigRepository;


    public List<ShopVipClassConfigEntity> getConfig() {

        //按照金额降序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"upgradeCondition");
        Sort sort = new Sort(order);
        List<ShopVipClassConfigEntity> list = shopVipClassConfigRepository.findAll(sort);
        if (list.size() == 0) {
            log.error("会员等级升级参数配置表信息未找到");
            throw new ShopException(ResultEnum.SHOPVIPCLASSCONFIG);
        }
        return list;
    }


}
