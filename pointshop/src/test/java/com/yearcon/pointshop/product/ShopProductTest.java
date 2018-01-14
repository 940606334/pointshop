package com.yearcon.pointshop.product;

import com.yearcon.pointshop.common.repository.mysql.product.ShopProductRepository;
import com.yearcon.pointshop.moudles.product.entity.ShopProductEntity;
import com.yearcon.pointshop.moudles.product.service.ShopProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-01-12 14:48
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopProductTest {


    @Autowired
    ShopProductService shopProductService;

    @Autowired
    ShopProductRepository shopProductRepository;



    @Test
    public void test1(){
        ShopProductEntity productEntity = shopProductService.findOne("40b");
        log.info("productEntity={}",productEntity);

    }


}
