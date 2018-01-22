package com.yearcon.pointshop.crm;

import com.yearcon.pointshop.common.repository.mysql.crm.PltJdOrderReposiyory;
import com.yearcon.pointshop.moudles.crm.entity.PltJdOrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-20 10:01
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PltJdOrderTest {

    @Autowired
    PltJdOrderReposiyory pltJdOrderReposiyory;


    @Test
    public void test(){
        List<PltJdOrderEntity> list = pltJdOrderReposiyory.findAllByPin("*yhd_adbmpwm");
        log.info("list={}",list.toString());


    }


}
