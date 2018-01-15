package com.yearcon.pointshop.signin;

import com.yearcon.pointshop.common.repository.mysql.signin.ShopSigninRepository;
import com.yearcon.pointshop.common.vo.ShopSigninInfoVO;
import com.yearcon.pointshop.moudles.signin.entity.ShopSigninEntity;
import com.yearcon.pointshop.moudles.signin.service.ShopSigninService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author itguang
 * @create 2018-01-15 9:46
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopSigninTest {

    @Autowired
    ShopSigninService shopSigninService;

    @Autowired
    ShopSigninRepository shopSigninRepository;


    @Test
    public void findAll() {

        List<ShopSigninEntity> list = shopSigninService.findAll(1, 10);

        list.stream()
                .forEach(System.out::println);

//        log.info("list={}",list.toString());

    }


    @Test
    public void findAllByCustomerIdAndSginDateBetween() {
        Date startDate = new Date(2018 - 1900, 1 - 1, 02);
        Date endDate = new Date(2018 - 1900, 1 - 1, 10);
        List<ShopSigninEntity> list = shopSigninRepository.findAllByCustomerIdAndSginDateBetweenOrderBySginDateAsc("123", startDate, endDate);

        log.info("list={}", list.size());
        list.stream()
                .forEach(System.out::println);
    }


    @Test
    public void calculatePoint() {

        Integer point = shopSigninService.calculatePoint("123");
        log.info("point={}", point);


    }

    @Test
    public void info(){
        ShopSigninInfoVO infoVO = shopSigninService.info("666");

        log.info("infoVO={}",infoVO.toString());
    }


    @Test
    public void getdaysOfMonth(){

        LocalDate now = LocalDate.now();
        LocalDate date1 = now.minusDays(1);
        LocalDate date2 = now.minusDays(2);
        LocalDate date3 = now.minusDays(3);
        LocalDate date4 = now.minusDays(4);

        ArrayList<LocalDate> dates = new ArrayList<>();




        dates.add(date4);
        dates.add(date3);
        dates.add(date2);
        dates.add(date1);
        dates.add(now);

        //dates.stream().sorted(Comparator.comparing(d->d.));

        Integer number = shopSigninService.getdaysOfMonth(dates);

        log.info("number={}",number);


    }


}
