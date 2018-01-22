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
 * @create 2018-01-20 9:18
 **/
@Entity
@Data
@Table(name = "temp_plt_taobao_customer", schema = "dsdb")
public class PltTaobaoCustomerEntity {

    /**
     * 淘宝id
     */
    private String customerno;
    private String fullName;
    private String sex;
    private Integer buyerCreditLev;
    private Integer buyerCreditScore;
    private Integer buyerCreditGoodNum;
    private Integer buyerCreditTotalNum;
    private String zip;
    private String address;
    private String city;
    private String state;
    private String country;
    private String district;
    private Timestamp created;
    private Timestamp lastVisit;
    private Date birthday;
    private String vipInfo;
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    private String phone;
    private Timestamp lastSync;
    private String job;
    private Short birthYear;
    private Timestamp changed;
    private String fullnameMost;
    private String mobileMost;
    private String phoneMost;
    private String countryMost;
    private String stateMost;
    private String cityMost;
    private String districtMost;
    private String addressMost;
    private Timestamp lastSyncMost;
    private String fullnameModified;
    private String mobileModified;
    private String emailModified;
    private Date birthdayModified;
    private String sexModified;
    private Timestamp updated;
    private Timestamp lastSyncUpdate;

    @Id
    @Column(name = "customerno", nullable = false, length = 50)
    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
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
    @Column(name = "sex", nullable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "buyer_credit_lev", nullable = true)
    public Integer getBuyerCreditLev() {
        return buyerCreditLev;
    }

    public void setBuyerCreditLev(Integer buyerCreditLev) {
        this.buyerCreditLev = buyerCreditLev;
    }

    @Basic
    @Column(name = "buyer_credit_score", nullable = true)
    public Integer getBuyerCreditScore() {
        return buyerCreditScore;
    }

    public void setBuyerCreditScore(Integer buyerCreditScore) {
        this.buyerCreditScore = buyerCreditScore;
    }

    @Basic
    @Column(name = "buyer_credit_good_num", nullable = true)
    public Integer getBuyerCreditGoodNum() {
        return buyerCreditGoodNum;
    }

    public void setBuyerCreditGoodNum(Integer buyerCreditGoodNum) {
        this.buyerCreditGoodNum = buyerCreditGoodNum;
    }

    @Basic
    @Column(name = "buyer_credit_total_num", nullable = true)
    public Integer getBuyerCreditTotalNum() {
        return buyerCreditTotalNum;
    }

    public void setBuyerCreditTotalNum(Integer buyerCreditTotalNum) {
        this.buyerCreditTotalNum = buyerCreditTotalNum;
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
    @Column(name = "country", nullable = true, length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 100)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "created", nullable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "last_visit", nullable = true)
    public Timestamp getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Timestamp lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "vip_info", nullable = true, length = 20)
    public String getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(String vipInfo) {
        this.vipInfo = vipInfo;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "phone", nullable = true, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "job", nullable = true, length = 50)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "birth_year", nullable = true)
    public Short getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Short birthYear) {
        this.birthYear = birthYear;
    }

    @Basic
    @Column(name = "changed", nullable = true)
    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    @Basic
    @Column(name = "fullname_most", nullable = true, length = 50)
    public String getFullnameMost() {
        return fullnameMost;
    }

    public void setFullnameMost(String fullnameMost) {
        this.fullnameMost = fullnameMost;
    }

    @Basic
    @Column(name = "mobile_most", nullable = true, length = 20)
    public String getMobileMost() {
        return mobileMost;
    }

    public void setMobileMost(String mobileMost) {
        this.mobileMost = mobileMost;
    }

    @Basic
    @Column(name = "phone_most", nullable = true, length = 50)
    public String getPhoneMost() {
        return phoneMost;
    }

    public void setPhoneMost(String phoneMost) {
        this.phoneMost = phoneMost;
    }

    @Basic
    @Column(name = "country_most", nullable = true, length = 100)
    public String getCountryMost() {
        return countryMost;
    }

    public void setCountryMost(String countryMost) {
        this.countryMost = countryMost;
    }

    @Basic
    @Column(name = "state_most", nullable = true, length = 50)
    public String getStateMost() {
        return stateMost;
    }

    public void setStateMost(String stateMost) {
        this.stateMost = stateMost;
    }

    @Basic
    @Column(name = "city_most", nullable = true, length = 50)
    public String getCityMost() {
        return cityMost;
    }

    public void setCityMost(String cityMost) {
        this.cityMost = cityMost;
    }

    @Basic
    @Column(name = "district_most", nullable = true, length = 100)
    public String getDistrictMost() {
        return districtMost;
    }

    public void setDistrictMost(String districtMost) {
        this.districtMost = districtMost;
    }

    @Basic
    @Column(name = "address_most", nullable = true, length = 255)
    public String getAddressMost() {
        return addressMost;
    }

    public void setAddressMost(String addressMost) {
        this.addressMost = addressMost;
    }

    @Basic
    @Column(name = "last_sync_most", nullable = true)
    public Timestamp getLastSyncMost() {
        return lastSyncMost;
    }

    public void setLastSyncMost(Timestamp lastSyncMost) {
        this.lastSyncMost = lastSyncMost;
    }

    @Basic
    @Column(name = "fullname_modified", nullable = true, length = 50)
    public String getFullnameModified() {
        return fullnameModified;
    }

    public void setFullnameModified(String fullnameModified) {
        this.fullnameModified = fullnameModified;
    }

    @Basic
    @Column(name = "mobile_modified", nullable = true, length = 20)
    public String getMobileModified() {
        return mobileModified;
    }

    public void setMobileModified(String mobileModified) {
        this.mobileModified = mobileModified;
    }

    @Basic
    @Column(name = "email_modified", nullable = true, length = 100)
    public String getEmailModified() {
        return emailModified;
    }

    public void setEmailModified(String emailModified) {
        this.emailModified = emailModified;
    }

    @Basic
    @Column(name = "birthday_modified", nullable = true)
    public Date getBirthdayModified() {
        return birthdayModified;
    }

    public void setBirthdayModified(Date birthdayModified) {
        this.birthdayModified = birthdayModified;
    }

    @Basic
    @Column(name = "sex_modified", nullable = true, length = 1)
    public String getSexModified() {
        return sexModified;
    }

    public void setSexModified(String sexModified) {
        this.sexModified = sexModified;
    }

    @Basic
    @Column(name = "updated", nullable = true)
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
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
