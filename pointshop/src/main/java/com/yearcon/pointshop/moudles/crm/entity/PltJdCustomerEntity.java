package com.yearcon.pointshop.moudles.crm.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-20 9:18
 **/
@Entity
@Data
@Table(name = "temp_plt_jd_customer", schema = "dsdb")
public class PltJdCustomerEntity {

    /**
     * 京东账号的id
     */
    private String pin;
    private String email;
    private String fullName;
    private String zip;
    private String address;
    private String city;
    private String state;
    private String district;
    private String mobile;
    private String telephone;
    private Timestamp lastSync;
    private Timestamp lastSyncUpdate;

    @Id
    @Column(name = "pin", nullable = false, length = 50)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "zip", nullable = true, length = 20)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 50)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 50)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 50)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "last_sync", nullable = true)
    public Timestamp getLastSync() {
        return lastSync;
    }

    public void setLastSync(Timestamp lastSync) {
        this.lastSync = lastSync;
    }

    @Basic
    @Column(name = "last_sync_update", nullable = false)
    public Timestamp getLastSyncUpdate() {
        return lastSyncUpdate;
    }

    public void setLastSyncUpdate(Timestamp lastSyncUpdate) {
        this.lastSyncUpdate = lastSyncUpdate;
    }


}
