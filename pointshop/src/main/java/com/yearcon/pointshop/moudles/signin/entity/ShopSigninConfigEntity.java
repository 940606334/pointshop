package com.yearcon.pointshop.moudles.signin.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-15 10:01
 **/
@Entity
@Data
@Table(name = "shop_signin_config", schema = "dsdb")
public class ShopSigninConfigEntity {
    private int id;
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    //签到次数
    private Integer signinTimes;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "one")
    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    @Basic
    @Column(name = "two")
    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }

    @Basic
    @Column(name = "three")
    public Integer getThree() {
        return three;
    }

    public void setThree(Integer three) {
        this.three = three;
    }

    @Basic
    @Column(name = "four")
    public Integer getFour() {
        return four;
    }

    public void setFour(Integer four) {
        this.four = four;
    }

    @Basic
    @Column(name = "signin_times")
    public Integer getSigninTimes() {
        return signinTimes;
    }

    public void setSigninTimes(Integer signinTimes) {
        this.signinTimes = signinTimes;
    }


}
