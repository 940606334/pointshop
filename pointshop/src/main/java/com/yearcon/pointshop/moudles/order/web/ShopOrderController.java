package com.yearcon.pointshop.moudles.order.web;

import com.yearcon.pointshop.common.anno.LoggerManage;
import com.yearcon.pointshop.common.dto.OrderDto;
import com.yearcon.pointshop.common.vo.ShopResult;
import com.yearcon.pointshop.moudles.order.entity.ShopOrderEntity;
import com.yearcon.pointshop.moudles.order.service.ShopOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author itguang
 * @create 2018-01-14 15:41
 **/
@Api(description = "订单管理")
@RestController
@RequestMapping("/order")
public class ShopOrderController {

    @Autowired
    ShopOrderService shopOrderService;



    @ApiOperation(value = "生成订单",notes = "生成订单,所有字段都为必填,创建成功则返回 订单id")
    @RequestMapping(value = "/save-order",method = RequestMethod.POST)
    @LoggerManage(logDescription = "生成订单")
    public ShopResult<Map<String,String>> saveOrder(OrderDto orderDto){


        String orderId = shopOrderService.save(orderDto);
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId",orderId);
        return ShopResult.success(map);
    }


    @ApiOperation(value = "获取所有订单信息",notes = "根据openid获取用户所有订单信息")
    @RequestMapping(value = "/getorder/{openid}",method = RequestMethod.GET)
    @LoggerManage(logDescription = "获取所有订单信息")
    public ShopResult<List<ShopOrderEntity>> getOrder(@PathVariable("openid") String openid){


        List<ShopOrderEntity> list = shopOrderService.findAll(openid);


        return ShopResult.success(list);
    }

    @ApiOperation(value = "查询单个订单信息",notes = "通过orderId 查询单个订单信息")
    @RequestMapping(value = "/getOrderByOrderId/{orderId}",method = RequestMethod.GET)
    @LoggerManage(logDescription = "查询单个订单信息")
    public ShopResult<ShopOrderEntity> getOrderByOrderId(@PathVariable("orderId") String orderId){
        ShopOrderEntity shopOrderEntity = shopOrderService.findOne(orderId);

        return ShopResult.success(shopOrderEntity);
    }


    @ApiOperation(value = "订单支付",notes = "根据订单id 和支付密码进行支付")
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    @LoggerManage(logDescription = "订单支付")
    public ShopResult pay(@ApiParam("订单id")@PathParam("orderId") String orderId,
                          @ApiParam("支付密码")@PathParam("payPassword") String payPassword){

        shopOrderService.pay(orderId,payPassword);

        return ShopResult.success();
    }


}
