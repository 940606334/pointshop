package com.yearcon.pointshop.moudles.user.web;

import com.yearcon.pointshop.moudles.user.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author itguang
 * @create 2018-01-08 10:56
 **/
@Api(description = "用户管理")
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {



    @ApiOperation(value = "测试", notes = "测试hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){

        return "hello";
    }

    @ApiOperation(value = "注册用户", notes = "用来进行用户注册,可匿名访问")
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(){
        return "signUp";

    }

    @ApiOperation(value = "用户登陆", notes = "登陆成功后,会在响应头中包含一个token,以后每次请求都需要在请求头中带上这个token值")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserEntity userEntity){
        String login = "login";
        return login;
    }



}
