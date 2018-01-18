package com.yearcon.pointshop.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author itguang
 * @create 2018-01-12 13:44
 **/
@Data
public class UserVO {


    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;
    /**
     * 用户名 (微信昵称)
     */
    @ApiModelProperty(value = "用户名(微信昵称)")
    private String username;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String headImage;
    /**
     * 当前等级
     */
    @ApiModelProperty(value = "当前等级",example = "当前等级")
    private String vipClass;

    @ApiModelProperty(value = "积分")
    private Integer point;

    /**
     * 卡券地址
     */
    @ApiModelProperty(value = "卡券地址")
    private String cardUrl;
    /**
     * vip特权
     */
    @ApiModelProperty(value = "vip特权")
    private String vipExplain;


    public UserVO(String phone, String username, String headImage, String vipClass, Integer point, String cardUrl, String vipExplain) {
        this.phone = phone;
        this.username = username;
        this.headImage = headImage;
        this.vipClass = vipClass;
        this.point = point;
        this.cardUrl = cardUrl;
        this.vipExplain = vipExplain;
    }
}
