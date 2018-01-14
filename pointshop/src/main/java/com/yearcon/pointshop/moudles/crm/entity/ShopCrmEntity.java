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
 * @create 2018-01-12 13:29
 **/
@Entity
@Data
@Table(name = "shop_crm", schema = "dsdb")
public class ShopCrmEntity {

    private int id;

    private String openid;
    /**
     * 淘宝消费金额
     */
    private Double taobao;
    /**
     * 京东消费金额
     */
    private Double jd;
    /**
     * 天猫消费金额
     */
    private Double tmall;
    /**
     * 其他平台消费金额
     */
    private Double other;
    /**
     * 当前等级
     */
    private String vipClass;
    /**
     * 同步crm数据库日期
     */
    private Date updateDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "openid")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "taobao")
    public Double getTaobao() {
        return taobao;
    }

    public void setTaobao(Double taobao) {
        this.taobao = taobao;
    }

    @Basic
    @Column(name = "jd")
    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    @Basic
    @Column(name = "tmall")
    public Double getTmall() {
        return tmall;
    }

    public void setTmall(Double tmall) {
        this.tmall = tmall;
    }

    @Basic
    @Column(name = "other")
    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    @Basic
    @Column(name = "vip_class")
    public String getVipClass() {
        return vipClass;
    }

    public void setVipClass(String vipClass) {
        this.vipClass = vipClass;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


}
