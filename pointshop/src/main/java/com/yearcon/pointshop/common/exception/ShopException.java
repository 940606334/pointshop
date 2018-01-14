package com.yearcon.pointshop.common.exception;

import com.yearcon.pointshop.common.enums.ResultEnum;
import lombok.Data;

/**
 * @author itguang
 * @create 2018-01-10 13:49
 **/
@Data
public class ShopException extends RuntimeException {

    private Integer code;

    public ShopException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }
}
