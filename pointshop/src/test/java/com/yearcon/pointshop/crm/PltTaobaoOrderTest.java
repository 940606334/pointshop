package com.yearcon.pointshop.crm;

import com.yearcon.pointshop.common.repository.mysql.crm.PltTaobaoOrderRepository;
import com.yearcon.pointshop.moudles.crm.entity.PltTaobaoOrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-20 10:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PltTaobaoOrderTest {


    @Autowired
    PltTaobaoOrderRepository pltTaobaoOrderRepository;


    @Test
    public void test(){

        List<PltTaobaoOrderEntity> list = pltTaobaoOrderRepository.findAllByCustomerno("-毛毛鸟-");
        log.info("list={}",list.toString());
    }

}
