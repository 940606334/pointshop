package com.yearcon.pointshop.moudles.signin.web;

import com.yearcon.pointshop.common.anno.LoggerManage;
import com.yearcon.pointshop.common.vo.ShopResult;
import com.yearcon.pointshop.common.vo.ShopSigninInfoVO;
import com.yearcon.pointshop.moudles.signin.entity.ShopSigninEntity;
import com.yearcon.pointshop.moudles.signin.service.ShopSigninService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author itguang
 * @create 2018-01-15 9:40
 **/
@RestController
@Api(description = "签到管理")
@RequestMapping("/signin")
public class ShopSigninController {

    @Autowired
    ShopSigninService shopSigninService;


    @ApiOperation(value = "获取签到记录", notes = "分页获取签到记录")
    @RequestMapping(value = "/list/{openid}", method = RequestMethod.POST)
    @LoggerManage(logDescription = "获取签到记录")
    public ShopResult<List<ShopSigninEntity>> findAll(@PathVariable(value = "openid") String openid,
                                                      @ApiParam(value = "起始页,从1开始") @RequestParam(value = "startPage", defaultValue = "1") Integer startPage,
                                                      @ApiParam(value = "页大小") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        List<ShopSigninEntity> list = shopSigninService.findAll(startPage, pageSize, openid);

        return ShopResult.success(list);
    }


    @ApiOperation(value = "保存签到信息", notes = "通过 openid 保存用户签到信息")
    @RequestMapping(value = "/save/{openid}", method = RequestMethod.GET)
    @LoggerManage(logDescription = "保存签到信息")
    public ShopResult signin(@PathVariable("openid") String openid) {

        shopSigninService.sginin(openid, "签到");

        return ShopResult.success();
    }

    @ApiOperation(value = "签到信息", notes = "通过opneid 获取签到信息")
    @RequestMapping(value = "/info/{openid}", method = RequestMethod.GET)
    @LoggerManage(logDescription = "签到信息")
    public ShopResult<ShopSigninInfoVO> info(@PathVariable("openid") String openid) {

        ShopSigninInfoVO infoVO = shopSigninService.info(openid);

        return ShopResult.success(infoVO);
    }



    @ApiOperation(value = "获取签到日期列表",notes = "通过openid获取该用户本月签到日期列表")
    @RequestMapping(value = "/getSigninDateList/{openid}",method = RequestMethod.GET)
    @LoggerManage(logDescription = "获取签到日期列表")
    public ShopResult getSigninDateList(@PathVariable(value = "openid") String openid){

        List<LocalDate> dates = shopSigninService.getSigninDateList(openid);

        return ShopResult.success(dates);
    }


}
