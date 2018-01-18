package com.yearcon.pointshop.moudles.signin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author itguang
 * @create 2018-01-15 9:12
 **/
@Entity
@Data
@Table(name = "shop_signin", schema = "dsdb")
public class ShopSigninEntity {

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private int id;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String customerId;

    @ApiModelProperty(value = "签到日期")
    private Date sginDate;
    @ApiModelProperty(value = "获得积分")
    private Integer signPoint;
    @ApiModelProperty(value = "积分余额")
    private Integer pointBalance;
    @ApiModelProperty(value = "类型")
    private String type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "sgin_date")
    public Date getSginDate() {
        return sginDate;
    }

    public void setSginDate(Date sginDate) {
        this.sginDate = sginDate;
    }

    @Basic
    @Column(name = "sign_point")
    public Integer getSignPoint() {
        return signPoint;
    }

    public void setSignPoint(Integer signPoint) {
        this.signPoint = signPoint;
    }

    @Basic
    @Column(name = "point_balance")
    public Integer getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(Integer pointBalance) {
        this.pointBalance = pointBalance;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
