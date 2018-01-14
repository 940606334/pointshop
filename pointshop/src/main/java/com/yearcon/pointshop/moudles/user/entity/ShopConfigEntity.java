package com.yearcon.pointshop.moudles.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author itguang
 * @create 2018-01-11 9:28
 **/
@Entity
@Table(name = "shop_config", schema = "dsdb")
@Data
public class ShopConfigEntity {

    @Id
    @Column(name = "id")
    private String id;
    private String appid;
    private String secret;
    /**
     * 前台页面域名
     */
    private String shopDomain;
    /**
     * 每日
     */
    private Integer pointDayCustome;
    /**
     * 起算时期
     */
    private Timestamp pointStartDate;
    /**
     * 积分清零日期
     */
    private Timestamp pointClearDate;
    /**
     * 卡券地址
     */
    private String cardUrl;
    /**
     * vip特权
     */
    private String vipExplain;




}
