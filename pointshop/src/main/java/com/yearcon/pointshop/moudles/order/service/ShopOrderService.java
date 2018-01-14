package com.yearcon.pointshop.moudles.order.service;

import com.yearcon.pointshop.common.dto.OrderDto;
import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.order.ShopOrderRepository;
import com.yearcon.pointshop.common.utils.Identities;
import com.yearcon.pointshop.moudles.address.entity.ShopShippingAddressEntity;
import com.yearcon.pointshop.moudles.address.service.ShopShippingAddressService;
import com.yearcon.pointshop.moudles.order.entity.ShopOrderEntity;
import com.yearcon.pointshop.moudles.product.entity.ShopProductEntity;
import com.yearcon.pointshop.moudles.product.service.ShopProductService;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author itguang
 * @create 2018-01-14 13:16
 **/
@Service
@Slf4j
public class ShopOrderService {


    @Autowired
    ShopOrderRepository shopOrderRepository;

    @Autowired
    ShopShippingAddressService shippingAddressService;

    @Autowired
    ShopProductService shopProductService;

    @Autowired
    ShopCustomerService shopCustomerService;


    /**
     * 生成订单
     *
     * @param orderDto
     * @return 返回订单id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public String save(OrderDto orderDto) {

        ShopShippingAddressEntity shippingAddressEntity = shippingAddressService.findOne(orderDto.getShoppingAddressId());

        ShopProductEntity shopProductEntity = shopProductService.findOne(orderDto.getProductId());

        ShopOrderEntity orderEntity = new ShopOrderEntity();


        //设置订单id
        orderEntity.setId(Identities.uuid2());

        //设置订单号
        orderEntity.setOrderNumber(Identities.createIdByDate());

        //设置交易号
        orderEntity.setTransactionNo(Identities.uuid2());

        //设置顾客id
        orderEntity.setCustomerId(shippingAddressEntity.getCustomerId());

        //设置商品简介
        orderEntity.setProductSimplename(shopProductEntity.getDescription());

        //设置商品单价
        orderEntity.setPrice(shopProductEntity.getPrice());

        //设置商品id
        orderEntity.setProductId(orderDto.getProductId());

        //设置商品名称
        orderEntity.setProductName(shopProductEntity.getName());

        //设置购买数量
        orderEntity.setProductAmount(orderDto.getProductAmount());

        //设置产品规格id
        orderEntity.setProductSpecificationId(orderDto.getProductSpecificationId());

        //设置收货地址id
        orderEntity.setShoppingAddressId(orderDto.getShoppingAddressId());

        //收货人姓名
        orderEntity.setConsignee(shippingAddressEntity.getName());

        //收件人手机
        orderEntity.setConsigneeMobile(shippingAddressEntity.getMobile());

        //应付积分
        orderEntity.setAmountPaid(orderDto.getProductAmount() * shopProductEntity.getPoints());

        //实付积分
        orderEntity.setAmountPaid(orderDto.getProductAmount() * shopProductEntity.getPoints());

        //设置发票要求
        orderEntity.setInvoiceRequest(orderDto.getInvoiceRequest());

        //设置发票抬头
        orderEntity.setInvoiceTitle(orderDto.getInvoiceTitle());

        //支付状态(0未支付/1已支付,默认为0)
        orderEntity.setPayStatus(0);

        //设置省
        orderEntity.setProvince(shippingAddressEntity.getProvince());

        //设置市
        orderEntity.setCity(shippingAddressEntity.getCity());

        //设置区
        orderEntity.setArea(shippingAddressEntity.getArea());

        //设置详细地址
        orderEntity.setShoppingAddressId(shippingAddressEntity.getCompleteAddress());

        //设置邮政编码
        orderEntity.setConsigneeCode(shippingAddressEntity.getPostcode());

        //设置快递状态:默认未发货
        orderEntity.setDeliveryStatus(1);

        //设置订单生成时间
        orderEntity.setAddTime(new Timestamp(System.currentTimeMillis()));

        //保存订单
        ShopOrderEntity shopOrderEntity = shopOrderRepository.save(orderEntity);

        if (shopOrderEntity == null) {
            log.info("【支付】：创建订单失败");
            throw new ShopException(ResultEnum.ORDER_NOT_EXIST);

        }
        return shopOrderEntity.getId();
    }


    /**
     * 支付
     *
     * @param orderId 订单id
     * @param passwd  支付密码
     */
    public void pay(String orderId, String passwd) {

        //查找订单是否存在
        ShopOrderEntity orderEntity = shopOrderRepository.findOne(orderId);
        if (orderEntity == null) {
            log.info("【支付】：修改订单状态失败");
            throw new ShopException(ResultEnum.PAY_FAIL);
        }


        //密码是否正确
        String customerId = orderEntity.getCustomerId();
        ShopCustomerEntity customerEntity = shopCustomerService.findOne(customerId);
        String payPassword = customerEntity.getPayPassword();
        if (!passwd.equals(payPassword)) {
            throw new ShopException(ResultEnum.PAY_PWD_ERROR);
        }

        //积分是否足够
        int point = customerEntity.getPoint();
        int amountPaid = orderEntity.getAmountPaid();

        if (point < amountPaid) {
            throw new ShopException(ResultEnum.PAY_POINT_NOT_ENOUGH_ERROR);
        }
        //减去相应积分值,并保存到数据库
        customerEntity.setPoint(point-amountPaid);
        shopCustomerService.save(customerEntity);


        //修改订单状态
        orderEntity.setPayStatus(1);

        //设置支付时间
        orderEntity.setPayTime(new Timestamp(System.currentTimeMillis()));

        ShopOrderEntity save = shopOrderRepository.save(orderEntity);
        if (save==null){

            throw new ShopException(ResultEnum.PAY_FAIL);
        }
    }

    /**
     * 订单查询
     *
     * @param orderId
     * @return
     */
    public ShopOrderEntity findOne(String orderId) {
        ShopOrderEntity orderEntity = shopOrderRepository.findOne(orderId);
        if (orderEntity == null) {
            throw new ShopException(ResultEnum.ORDER_NO);

        }

        return orderEntity;

    }


    /**
     * 删除订单
     *
     * @param orderID
     */
    public void delete(String orderID) {
        shopOrderRepository.delete(orderID);
    }

    /**
     * 通过 customerId 查找所有相关订单
     *
     * @param openid
     * @return
     */
   public List<ShopOrderEntity> findAll(String openid) {

        ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(openid);

        if (customerEntity == null) {
            throw new ShopException(ResultEnum.NOT_EXIST);
        }

        String customerId = customerEntity.getId();

        List<ShopOrderEntity> list = shopOrderRepository.findAllByCustomerId(customerId);

        if (list.size() < 1) {
            throw new ShopException(ResultEnum.ORDER_NO);
        }

        return list;


    }

}