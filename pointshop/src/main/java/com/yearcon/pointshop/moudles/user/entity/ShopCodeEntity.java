package com.yearcon.pointshop.moudles.user.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-17 16:20
 **/
@Entity
@Data
@Table(name = "shop_code", schema = "dsdb")
public class ShopCodeEntity {
    private int id;
    private String code;
    private String phone;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public ShopCodeEntity() {
    }

    public ShopCodeEntity(String code, String phone) {
        this.code = code;
        this.phone = phone;
    }
}
