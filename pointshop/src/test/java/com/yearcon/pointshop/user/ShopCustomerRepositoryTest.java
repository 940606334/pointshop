package com.yearcon.pointshop.user;

import com.yearcon.pointshop.common.repository.mysql.user.ShopCustomerRepository;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-01-10 16:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCustomerRepositoryTest {


    @Autowired
    ShopCustomerRepository shopCustomerRepository;




    @Test
    public void findByOpenid (){
        ShopCustomerEntity shopCustomerEntity = shopCustomerRepository.findByOpenid("oaSr408dv6kyh3Ai9CdpBkDFmbDg");
        System.out.println(shopCustomerEntity.toString());

    }


}
