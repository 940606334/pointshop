package com.yearcon.pointshop.user;

import com.yearcon.pointshop.common.repository.mysql.user.ShopCustomerRepository;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

/**
 * @author itguang
 * @create 2018-01-10 16:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopCustomerRepositoryTest {


    @Autowired
    ShopCustomerRepository shopCustomerRepository;

    @Autowired
    ShopCustomerService shopCustomerService;




    @Test
    public void findByOpenid (){
        ShopCustomerEntity shopCustomerEntity = shopCustomerRepository.findByOpenid("oaSr408dv6kyh3Ai9CdpBkDFmbDg");
        System.out.println(shopCustomerEntity.toString());

    }

    @Test
    public void test(){
        String dbCode = shopCustomerService.findByPhone("17638166573");
        log.info("dbCode={}",dbCode);

    }


}
