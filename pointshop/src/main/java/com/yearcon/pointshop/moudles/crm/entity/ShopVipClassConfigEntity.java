package com.yearcon.pointshop.moudles.crm.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-20 13:01
 **/
@Entity
@Data
@Table(name = "shop_vip_class_config", schema = "dsdb")
public class ShopVipClassConfigEntity {
    private int id;
    private String vipClassName;
    /**
     * 升级条件
     */
    private Integer upgradeCondition;
    private Integer convertPoint;
    private Date validity;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vip_class_name", nullable = true, length = 50)
    public String getVipClassName() {
        return vipClassName;
    }

    public void setVipClassName(String vipClassName) {
        this.vipClassName = vipClassName;
    }

    @Basic
    @Column(name = "upgrade_condition", nullable = true)
    public Integer getUpgradeCondition() {
        return upgradeCondition;
    }

    public void setUpgradeCondition(Integer upgradeCondition) {
        this.upgradeCondition = upgradeCondition;
    }

    @Basic
    @Column(name = "convert_point", nullable = true)
    public Integer getConvertPoint() {
        return convertPoint;
    }

    public void setConvertPoint(Integer convertPoint) {
        this.convertPoint = convertPoint;
    }

    @Basic
    @Column(name = "validity", nullable = true)
    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }


}
