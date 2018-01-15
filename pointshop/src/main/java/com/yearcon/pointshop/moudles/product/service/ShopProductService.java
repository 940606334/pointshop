package com.yearcon.pointshop.moudles.product.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.product.ShopProductRepository;
import com.yearcon.pointshop.common.repository.mysql.product.ShopProductSpecificationRepository;
import com.yearcon.pointshop.moudles.product.entity.ShopProductEntity;
import com.yearcon.pointshop.moudles.product.entity.ShopProductSpecificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<ShopProductSpecificationEntity> findAllByProductId(String productId) {
        List<ShopProductSpecificationEntity> specificationEntity = shopProductSpecificationRepository.findAllByProductId(productId);
        if (specificationEntity.size() == 0) {
            throw new ShopException(ResultEnum.SPECIFICATION_NOT_EXIST);
        }

        return specificationEntity;
    }

    /**
     * 分页查找商品
     * @param startIndex 起始页,从1开始
     * @param pageSize 每页大小
     * @return
     */
    public  List<ShopProductEntity> findAll(int startIndex, int pageSize) {

        //按照排序字段进行排序
        Sort.Order sortNo = new Sort.Order(Sort.Direction.DESC, "sortNo");
        //按销量进行排序
        Sort.Order sales = new Sort.Order(Sort.Direction.DESC, "sales");

        ArrayList<Sort.Order> orders = new ArrayList<>();
        orders.add(sortNo);
        orders.add(sales);

        Sort sort = new Sort(orders);


        Pageable pageable = new PageRequest(startIndex-1, pageSize,sort);

        Page<ShopProductEntity> page = shopProductRepository.findAll(pageable);

        List<ShopProductEntity> list = page.getContent();

        return list;
    }


}
