package com.yearcon.pointshop.test;

import com.yearcon.pointshop.common.repository.mysql.test.UserRository1;
import com.yearcon.pointshop.common.repository.oracle.test.UserRository2;
import com.yearcon.pointshop.moudles.test.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-05 15:15
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitTest {

    @Autowired
    private UserRository1 userRository1;

    @Autowired
    private UserRository2 userRository2;


    @Test
    public void test1(){
        List<UserEntity> list = userRository1.findAll();
        System.out.println(list.toString());

    }
    @Test
    public void test2(){
        List<UserEntity> list = userRository2.findAll();
        System.out.println(list.toString());

    }




}
