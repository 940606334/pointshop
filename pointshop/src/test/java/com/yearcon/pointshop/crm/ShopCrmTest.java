package com.yearcon.pointshop.crm;

import com.yearcon.pointshop.common.repository.mysql.crm.ShopCrmRepository;
import com.yearcon.pointshop.moudles.crm.entity.ShopCrmEntity;
import com.yearcon.pointshop.moudles.crm.service.ShopCrmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-01-12 13:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopCrmTest {

    @Autowired
    private ShopCrmRepository shopCrmRepository;

    @Autowired
    private ShopCrmService shopCrmService;



    @Test
    public void test1(){
        ShopCrmEntity shopCrmEntity = shopCrmRepository.findOne(1);

        log.info("shopCrmEntity={}",shopCrmEntity);


    }


    @Test
    public void test2(){
        ShopCrmEntity shopCrmEntity = shopCrmService.getByOpenid("oaSr40zTQcLIK5W9H2W3ZaaBwO6g");

        log.info("shopCrmEntity={}",shopCrmEntity);


    }



    @Test
    public void test3(){
        ShopCrmEntity shopCrmEntity = shopCrmRepository.findByMobile("17638166573");
        log.info("shopCrmEntity={}",shopCrmEntity);


    }



}
