package com.yearcon.pointshop.common.vo;

import com.yearcon.pointshop.common.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回 json 信息
 *
 * @author itguang
 * @create 2018-01-11 13:21
 **/
@Data
public class ShopResult<T> implements Serializable {


    private Integer status;
    private String msg;
    private T data;


    public ShopResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ShopResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ShopResult(ResultEnum resultEnum, T data) {
        this.status = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ShopResult(ResultEnum resultEnum) {
        this.status = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public static ShopResult success() {
        return new ShopResult(ResultEnum.SUCCESS);
    }

    public static ShopResult success(Object data) {
        return new ShopResult(ResultEnum.SUCCESS, data);
    }
}
