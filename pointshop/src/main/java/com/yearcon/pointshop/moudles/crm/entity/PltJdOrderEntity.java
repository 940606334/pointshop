package com.yearcon.pointshop.moudles.crm.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-20 9:18
 **/
@Entity
@Data
@Table(name = "temp_plt_jd_order", schema = "dsdb")
public class PltJdOrderEntity {
    private String orderId;
    private String venderId;
    private String payType;
    private Double orderTotalPrice;
    private BigDecimal orderPayment;
    /**
     * 实际付款金额
     */
    private Double orderSellerPrice;
    private BigDecimal freightPrice;
    private BigDecimal sellerDiscount;
    private String orderState;
    private String deliveryType;
    private String invoiceInfo;
    private String orderRemark;
    private Timestamp orderStartTime;
    private Timestamp orderEndTime;
    private String fullname;
    private String fullAddress;
    private String telephone;
    private String mobile;
    private String province;
    private String city;
    private String county;
    private String returnOrder;
    private String venderRemark;
    private String pin;
    private BigDecimal balanceUsed;
    private Timestamp modified;
    private Timestamp paymentConfirmTime;
    private String logisticsId;
    private String waybill;
    private String parentOrderId;
    private Timestamp tradeInsert;
    private Timestamp tradeUpdate;
    private Integer itemTotal;
    private String shopId;
    private Timestamp lastSync;

    @Id
    @Column(name = "order_id", nullable = false, length = 50)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "vender_id", nullable = true, length = 50)
    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    @Basic
    @Column(name = "pay_type", nullable = true, length = 20)
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "order_total_price", nullable = true, precision = 2)
    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    @Basic
    @Column(name = "order_payment", nullable = true, precision = 2)
    public BigDecimal getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(BigDecimal orderPayment) {
        this.orderPayment = orderPayment;
    }



    @Basic
    @Column(name = "freight_price", nullable = true, precision = 2)
    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    @Basic
    @Column(name = "seller_discount", nullable = true, precision = 2)
    public BigDecimal getSellerDiscount() {
        return sellerDiscount;
    }

    public void setSellerDiscount(BigDecimal sellerDiscount) {
        this.sellerDiscount = sellerDiscount;
    }

    @Basic
    @Column(name = "order_state", nullable = true, length = 50)
    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Basic
    @Column(name = "delivery_type", nullable = true, length = 50)
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Basic
    @Column(name = "invoice_info", nullable = true, length = 100)
    public String getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(String invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    @Basic
    @Column(name = "order_remark", nullable = true, length = 100)
    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    @Basic
    @Column(name = "order_start_time", nullable = true)
    public Timestamp getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Timestamp orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    @Basic
    @Column(name = "order_end_time", nullable = true)
    public Timestamp getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Timestamp orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    @Basic
    @Column(name = "fullname", nullable = true, length = 50)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "full_address", nullable = true, length = 255)
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
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
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 50)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
    @Column(name = "county", nullable = true, length = 50)
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "return_order", nullable = true, length = 10)
    public String getReturnOrder() {
        return returnOrder;
    }

    public void setReturnOrder(String returnOrder) {
        this.returnOrder = returnOrder;
    }

    @Basic
    @Column(name = "vender_remark", nullable = true, length = 500)
    public String getVenderRemark() {
        return venderRemark;
    }

    public void setVenderRemark(String venderRemark) {
        this.venderRemark = venderRemark;
    }

    @Basic
    @Column(name = "pin", nullable = true, length = 50)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "balance_used", nullable = true, precision = 2)
    public BigDecimal getBalanceUsed() {
        return balanceUsed;
    }

    public void setBalanceUsed(BigDecimal balanceUsed) {
        this.balanceUsed = balanceUsed;
    }

    @Basic
    @Column(name = "modified", nullable = true)
    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Basic
    @Column(name = "payment_confirm_time", nullable = true)
    public Timestamp getPaymentConfirmTime() {
        return paymentConfirmTime;
    }

    public void setPaymentConfirmTime(Timestamp paymentConfirmTime) {
        this.paymentConfirmTime = paymentConfirmTime;
    }

    @Basic
    @Column(name = "logistics_id", nullable = true, length = 200)
    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    @Basic
    @Column(name = "waybill", nullable = true, length = 200)
    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    @Basic
    @Column(name = "parent_order_id", nullable = true, length = 50)
    public String getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(String parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    @Basic
    @Column(name = "trade_insert", nullable = true)
    public Timestamp getTradeInsert() {
        return tradeInsert;
    }

    public void setTradeInsert(Timestamp tradeInsert) {
        this.tradeInsert = tradeInsert;
    }

    @Basic
    @Column(name = "trade_update", nullable = true)
    public Timestamp getTradeUpdate() {
        return tradeUpdate;
    }

    public void setTradeUpdate(Timestamp tradeUpdate) {
        this.tradeUpdate = tradeUpdate;
    }

    @Basic
    @Column(name = "item_total", nullable = true, precision = 0)
    public Integer getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Integer itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Basic
    @Column(name = "shop_id", nullable = false, length = 20)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "last_sync", nullable = false)
    public Timestamp getLastSync() {
        return lastSync;
    }

    public void setLastSync(Timestamp lastSync) {
        this.lastSync = lastSync;
    }


}
