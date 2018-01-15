package com.yearcon.pointshop.product;

import com.yearcon.pointshop.common.repository.mysql.product.ShopProductRepository;
import com.yearcon.pointshop.moudles.product.entity.ShopProductEntity;
import com.yearcon.pointshop.moudles.product.service.ShopProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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


    @Test
    public void findAll(){

        List<ShopProductEntity> list = shopProductService.findAll(1, 5);

//
//        System.out.println("总页数=" + page.getTotalPages());
//        //使用Lambda进行遍历
//        List<ShopProductEntity> list = page.getContent();
        list.stream()
                .forEach(System.out::println);
//
//        System.out.println("本页包含记录=" + page.getContent());
//        System.out.println("总记录数=" + page.getTotalElements());
//        System.out.println("当前第几页=" + page.getNumber());
//        System.out.println("页大小=" + page.getSize());
//        System.out.println("是否还有下一页=" + page.hasNext());
//        System.out.println("是否还有上一页=" + page.hasPrevious());
//        System.out.println("是否是第一页=" + page.isFirst());
//        System.out.println("是否是最后一页=" + page.isLast());


    }


}
