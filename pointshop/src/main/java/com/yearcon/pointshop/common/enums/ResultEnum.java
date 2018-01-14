package com.yearcon.pointshop.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(1,"成功"),
    PHONE_NOT_EXIST(2,"手机号还未注册"),

    SIGNATUREEXCEPTION(100,"校验token失败"),
    EXPIREDJWTEXCEPTION(101,"token已过期,请重新登陆"),
    CHECK_CODE_FAILE(102,"验证码验证失败"),
    SEND_CODE_FAILE(103,"发送验证码失败"),
    NOT_EXIST(104,"找不到该用户相关信息"),
    PRODUCT_NOT_EXIST(105,"找不到该商品相关信息"),
    SPECIFICATION_NOT_EXIST(106,"没有找到该商品规格信息"),
    SAVE_ADDRESS_FAIL(107,"保存收货地址失败"),
    ADDRESS_NOT_FIND(108,"您还没有填写收货地址"),
    ADDRESS_NOT_EXIST(109,"该收货地址不存在"),
    ORDER_NOT_EXIST(110,"创建订单失败"),
    ORDER_NO(111,"未能查找到相关订单"),
    PAY_FAIL(112,"支付失败,未能找到相关订单"),
    PAY_PWD_ERROR(113,"支付失败,支付密码错误"),
    PAY_POINT_NOT_ENOUGH_ERROR(114,"支付失败,积分不足"),
    SAVE_CUSTOMER_FAIL(115,"保存用户信息失败"),




    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
