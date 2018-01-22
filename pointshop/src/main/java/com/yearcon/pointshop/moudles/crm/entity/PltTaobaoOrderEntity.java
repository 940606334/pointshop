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
@Table(name = "temp_plt_taobao_order", schema = "dsdb")
public class PltTaobaoOrderEntity {
    private String tid;
    private String dpId;
    private String customerno;
    private Timestamp created;
    private Timestamp endtime;
    private String status;
    private String stepTradeStatus;
    private String tradeFrom;
    private String type;
    private Timestamp payTime;
    private BigDecimal totalFee;
    private BigDecimal postFee;
    private Timestamp consignTime;
    private short ccmsOrderStatus;
    private Timestamp modified;
    private String alipayNo;
    private double payment;
    private BigDecimal discountFee;
    private BigDecimal pointFee;
    private BigDecimal realPointFee;
    private String shippingType;
    private BigDecimal buyerCodFee;
    private BigDecimal sellerCodFee;
    private BigDecimal expressAgencyFee;
    private BigDecimal adjustFee;
    private BigDecimal buyerObtainPointFee;
    private BigDecimal codFee;
    private String codStatus;
    private String buyerAlipayNo;
    private String receiverName;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
    private String receiverMobile;
    private String receiverPhone;
    private String buyerEmail;
    private BigDecimal commissionFee;
    private BigDecimal refundFee;
    private Integer num;
    private BigDecimal receivedPayment;
    private String buyerMemo;
    private String sellerMemo;
    private String sellerFlag;
    private Integer sellerRate;
    private Byte buyerRate;
    private Timestamp tradeInsert;
    private Timestamp tradeUpdate;
    private Timestamp lastSync;

    @Id
    @Column(name = "tid", nullable = false, length = 50)
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "dp_id", nullable = false, length = 50)
    public String getDpId() {
        return dpId;
    }

    public void setDpId(String dpId) {
        this.dpId = dpId;
    }

    @Basic
    @Column(name = "customerno", nullable = false, length = 50)
    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
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
    @Column(name = "endtime", nullable = true)
    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "step_trade_status", nullable = true, length = 50)
    public String getStepTradeStatus() {
        return stepTradeStatus;
    }

    public void setStepTradeStatus(String stepTradeStatus) {
        this.stepTradeStatus = stepTradeStatus;
    }

    @Basic
    @Column(name = "trade_from", nullable = true, length = 50)
    public String getTradeFrom() {
        return tradeFrom;
    }

    public void setTradeFrom(String tradeFrom) {
        this.tradeFrom = tradeFrom;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "pay_time", nullable = true)
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "total_fee", nullable = true, precision = 2)
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    @Basic
    @Column(name = "post_fee", nullable = true, precision = 2)
    public BigDecimal getPostFee() {
        return postFee;
    }

    public void setPostFee(BigDecimal postFee) {
        this.postFee = postFee;
    }

    @Basic
    @Column(name = "consign_time", nullable = true)
    public Timestamp getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Timestamp consignTime) {
        this.consignTime = consignTime;
    }

    @Basic
    @Column(name = "ccms_order_status", nullable = false)
    public short getCcmsOrderStatus() {
        return ccmsOrderStatus;
    }

    public void setCcmsOrderStatus(short ccmsOrderStatus) {
        this.ccmsOrderStatus = ccmsOrderStatus;
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
    @Column(name = "alipay_no", nullable = true, length = 50)
    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    @Basic
    @Column(name = "payment", nullable = false, precision = 2)
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "discount_fee", nullable = true, precision = 2)
    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    @Basic
    @Column(name = "point_fee", nullable = true, precision = 2)
    public BigDecimal getPointFee() {
        return pointFee;
    }

    public void setPointFee(BigDecimal pointFee) {
        this.pointFee = pointFee;
    }

    @Basic
    @Column(name = "real_point_fee", nullable = true, precision = 2)
    public BigDecimal getRealPointFee() {
        return realPointFee;
    }

    public void setRealPointFee(BigDecimal realPointFee) {
        this.realPointFee = realPointFee;
    }

    @Basic
    @Column(name = "shipping_type", nullable = true, length = 20)
    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    @Basic
    @Column(name = "buyer_cod_fee", nullable = true, precision = 2)
    public BigDecimal getBuyerCodFee() {
        return buyerCodFee;
    }

    public void setBuyerCodFee(BigDecimal buyerCodFee) {
        this.buyerCodFee = buyerCodFee;
    }

    @Basic
    @Column(name = "seller_cod_fee", nullable = true, precision = 2)
    public BigDecimal getSellerCodFee() {
        return sellerCodFee;
    }

    public void setSellerCodFee(BigDecimal sellerCodFee) {
        this.sellerCodFee = sellerCodFee;
    }

    @Basic
    @Column(name = "express_agency_fee", nullable = true, precision = 2)
    public BigDecimal getExpressAgencyFee() {
        return expressAgencyFee;
    }

    public void setExpressAgencyFee(BigDecimal expressAgencyFee) {
        this.expressAgencyFee = expressAgencyFee;
    }

    @Basic
    @Column(name = "adjust_fee", nullable = true, precision = 2)
    public BigDecimal getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(BigDecimal adjustFee) {
        this.adjustFee = adjustFee;
    }

    @Basic
    @Column(name = "buyer_obtain_point_fee", nullable = true, precision = 2)
    public BigDecimal getBuyerObtainPointFee() {
        return buyerObtainPointFee;
    }

    public void setBuyerObtainPointFee(BigDecimal buyerObtainPointFee) {
        this.buyerObtainPointFee = buyerObtainPointFee;
    }

    @Basic
    @Column(name = "cod_fee", nullable = true, precision = 2)
    public BigDecimal getCodFee() {
        return codFee;
    }

    public void setCodFee(BigDecimal codFee) {
        this.codFee = codFee;
    }

    @Basic
    @Column(name = "cod_status", nullable = true, length = 30)
    public String getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }

    @Basic
    @Column(name = "buyer_alipay_no", nullable = true, length = 100)
    public String getBuyerAlipayNo() {
        return buyerAlipayNo;
    }

    public void setBuyerAlipayNo(String buyerAlipayNo) {
        this.buyerAlipayNo = buyerAlipayNo;
    }

    @Basic
    @Column(name = "receiver_name", nullable = true, length = 50)
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Basic
    @Column(name = "receiver_state", nullable = true, length = 50)
    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    @Basic
    @Column(name = "receiver_city", nullable = true, length = 50)
    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    @Basic
    @Column(name = "receiver_district", nullable = true, length = 50)
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    @Basic
    @Column(name = "receiver_address", nullable = true, length = 255)
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    @Basic
    @Column(name = "receiver_zip", nullable = true, length = 10)
    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    @Basic
    @Column(name = "receiver_mobile", nullable = true, length = 20)
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    @Basic
    @Column(name = "receiver_phone", nullable = true, length = 50)
    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Basic
    @Column(name = "buyer_email", nullable = true, length = 100)
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    @Basic
    @Column(name = "commission_fee", nullable = true, precision = 2)
    public BigDecimal getCommissionFee() {
        return commissionFee;
    }

    public void setCommissionFee(BigDecimal commissionFee) {
        this.commissionFee = commissionFee;
    }

    @Basic
    @Column(name = "refund_fee", nullable = true, precision = 2)
    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    @Basic
    @Column(name = "num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "received_payment", nullable = true, precision = 2)
    public BigDecimal getReceivedPayment() {
        return receivedPayment;
    }

    public void setReceivedPayment(BigDecimal receivedPayment) {
        this.receivedPayment = receivedPayment;
    }

    @Basic
    @Column(name = "buyer_memo", nullable = true, length = 1000)
    public String getBuyerMemo() {
        return buyerMemo;
    }

    public void setBuyerMemo(String buyerMemo) {
        this.buyerMemo = buyerMemo;
    }

    @Basic
    @Column(name = "seller_memo", nullable = true, length = 1000)
    public String getSellerMemo() {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
        this.sellerMemo = sellerMemo;
    }

    @Basic
    @Column(name = "seller_flag", nullable = true, length = 50)
    public String getSellerFlag() {
        return sellerFlag;
    }

    public void setSellerFlag(String sellerFlag) {
        this.sellerFlag = sellerFlag;
    }

    @Basic
    @Column(name = "seller_rate", nullable = true)
    public Integer getSellerRate() {
        return sellerRate;
    }

    public void setSellerRate(Integer sellerRate) {
        this.sellerRate = sellerRate;
    }

    @Basic
    @Column(name = "buyer_rate", nullable = true)
    public Byte getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Byte buyerRate) {
        this.buyerRate = buyerRate;
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
    @Column(name = "last_sync", nullable = false)
    public Timestamp getLastSync() {
        return lastSync;
    }

    public void setLastSync(Timestamp lastSync) {
        this.lastSync = lastSync;
    }

}
