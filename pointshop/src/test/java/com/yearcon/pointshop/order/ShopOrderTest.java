package com.yearcon.pointshop.order;

import com.yearcon.pointshop.common.dto.OrderDto;
import com.yearcon.pointshop.moudles.order.entity.ShopOrderEntity;
import com.yearcon.pointshop.moudles.order.service.ShopOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-14 15:01
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopOrderTest {

    @Autowired
    ShopOrderService shopOrderService;


    /**
     * 生成订单
     */
    @Test
    public void save(){
        OrderDto orderDto = new OrderDto();
        orderDto.setInvoiceRequest("test_需要发票");
        orderDto.setInvoiceTitle("test_光");
        orderDto.setProductAmount(2);
        orderDto.setProductId("40b0f0a8a864b86440b92bb");
        orderDto.setProductSpecificationId("0eda8337f45e42a99e874454b1e5b52c");
        orderDto.setShoppingAddressId("074d66aff8244293b08b08e58d9ed832");
        orderDto.setRemarkBuyer("test_赶紧的发货");
        String orderId = shopOrderService.save(orderDto);

        log.info("orderId={}",orderId);
    }

    /**
     * 支付
     */
    @Test
    public void pay(){
        shopOrderService.pay("c75c981c5d1241bdb7689f917ea6dc60","777777");
    }

    /**
     * 获取订单列表
     */
    @Test
    public  void  getAll(){
        List<ShopOrderEntity> list = shopOrderService.findAll("123");
        log.info("list={}",list.toString());
    }







}
