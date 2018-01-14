package com.yearcon.pointshop.moudles.product.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.product.ShopProductRepository;
import com.yearcon.pointshop.common.repository.mysql.product.ShopProductSpecificationRepository;
import com.yearcon.pointshop.moudles.product.entity.ShopProductEntity;
import com.yearcon.pointshop.moudles.product.entity.ShopProductSpecificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-12 14:45
 **/
@Service
public class ShopProductService {

    @Autowired
    ShopProductRepository shopProductRepository;

    @Autowired
    ShopProductSpecificationRepository shopProductSpecificationRepository;


    public ShopProductEntity findOne(String id) {
        ShopProductEntity productEntity = shopProductRepository.findOne(id);
        if (productEntity == null) {
            throw new ShopException(ResultEnum.PRODUCT_NOT_EXIST);

        }
        return productEntity;

    }


    public List<ShopProductSpecificationEntity >findAllByProductId(String productId){
        List<ShopProductSpecificationEntity> specificationEntity = shopProductSpecificationRepository.findAllByProductId(productId);
        if(specificationEntity.size()==0){
            throw new ShopException(ResultEnum.SPECIFICATION_NOT_EXIST);
        }

        return specificationEntity;
    }





}
