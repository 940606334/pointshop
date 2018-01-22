package com.yearcon.pointshop.crm;

import com.yearcon.pointshop.common.repository.mysql.crm.PltTaobaoCustomerRepository;
import com.yearcon.pointshop.moudles.crm.entity.PltTaobaoCustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-20 9:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PltTaobaoCustomerTest {

    @Autowired
    PltTaobaoCustomerRepository pltTaobaoCustomerRepository;

    @Test
    public void test(){
        List<PltTaobaoCustomerEntity> list = pltTaobaoCustomerRepository.findAllByMobile("13065223242");
        log.info("list={}",list.toString());
    }


    @Test
    public void test2(){
        List<PltTaobaoCustomerEntity> list = pltTaobaoCustomerRepository.myfindAllByMobile("13065223242");
        log.info("list={}",list.toString());
    }


}
