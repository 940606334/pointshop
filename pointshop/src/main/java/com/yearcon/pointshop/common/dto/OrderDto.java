package com.yearcon.pointshop.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author itguang
 * @create 2018-01-14 13:18
 **/
@Data
public class OrderDto {

    @ApiModelProperty(value = "产品id")
    private String productId;

    @ApiModelProperty(value = "产品规格id")
    private String productSpecificationId;

    @ApiModelProperty(value = "收货地址id")
    private String shoppingAddressId;

    @ApiModelProperty(value = "购买数量")
    private Integer productAmount;

    @ApiModelProperty(value = "发票要求")
    private String invoiceRequest;

    @ApiModelProperty(value = "发票抬头")
    private String invoiceTitle;

    @ApiModelProperty(value = "买家留言")
    private String remarkBuyer;


}
