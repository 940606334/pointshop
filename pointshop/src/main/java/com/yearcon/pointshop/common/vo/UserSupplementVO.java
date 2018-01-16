package com.yearcon.pointshop.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 完善用户信息
 *
 * @author itguang
 * @create 2018-01-16 8:26
 **/
@Data
public class UserSupplementVO {

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;
    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String username;

    /**
     * 关联的 淘宝账号
     */
    @ApiModelProperty(value = "淘宝账号")
    private String taobaoId;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private String birthday;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 尺码
     */
    @ApiModelProperty(value = "尺码")
    private String size;


}
