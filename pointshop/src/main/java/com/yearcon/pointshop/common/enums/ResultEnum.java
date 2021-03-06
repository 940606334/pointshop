package com.yearcon.pointshop.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(1,"成功"),
    PHONE_NOT_EXIST(2,"手机号还未注册"),
    SIGNIN_TIME_FULL(3,"本周签到次数已达上线"),


    UNKNOW_ERROR(-1,"未知错误"),

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
    SAVE_SIGNIN_POINT_FAIL(116,"保存签到信息失败"),
    SIGNIN_FAIL(117,"今天已经签到过了"),
    CONFIG_NOT_EXIST(118,"商城基本配置信息未找到"),
    SAVE_CODE_FAIL(119,"验证码失败"),
    RECORD_FAIL(120,"添加消费记录失败"),
    SAVE_PRODUCT_FAIL(121,"保存商品销量失败"),
    SAVE_PRODUCTSPECIFICATION_FAIL(122,"减库存失败"),
    SHOPVIPCLASSCONFIG(123,"会员等级升级参数配置表信息未找到"),
    PARAM_ERROR(124,"传递单参数 type 有误!"),





    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
