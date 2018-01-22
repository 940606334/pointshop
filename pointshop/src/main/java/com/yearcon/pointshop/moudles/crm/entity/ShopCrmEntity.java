package com.yearcon.pointshop.moudles.crm.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-19 13:23
 **/
@Entity
@Data
@Table(name = "shop_crm", schema = "dsdb")
public class ShopCrmEntity {

    @Id
    private int id;
    private String openid;
    private Double taobao;
    private Double jd;
    private Double tmall;
    private Double other;
    private String vipClass;
    private Date updateDate;
    private String mobile;



}
