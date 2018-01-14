package com.yearcon.pointshop.common.handler;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.vo.ShopResult;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 全局异常统一处理
 * @author itguang
 * @create 2018-01-11 13:25
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(value = ExpiredJwtException.class)
    @ResponseBody
    public ShopResult handleSportException(ExpiredJwtException e) {
        return new ShopResult(ResultEnum.EXPIREDJWTEXCEPTION);
    }

    @ExceptionHandler(value = ShopException.class)
    @ResponseBody
    public ShopResult handleSportException(ShopException e) {
        log.error("【自定义全局异常:SportException=】:"+e.getCode()+":"+e.getMessage());
        return new ShopResult(e.getCode(), e.getMessage());
    }








}
