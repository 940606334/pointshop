package com.yearcon.pointshop.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * @author itguang
 * @create 2018-01-15 14:58
 **/
@Data
public class ShopSigninInfoVO {


    /**
     * 连续签到
     */
    @ApiModelProperty(value = "连续签到")
    private Integer days;


    /**
     * 本月签到天数
     */
    @ApiModelProperty(value = "本月签到天数")
    private Integer daysMonth;

    /**
     * 签到获得积分
     */
    @ApiModelProperty(value = "签到获得积分")
    private Integer points;

    /**
     * 签到日期
     */
    @ApiModelProperty(value = "签到日期")
    private List<LocalDate> dates;


}
