package com.yearcon.pointshop.moudles.order.entity;

import io.swagger.annotations.ApiModelProperty;
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
 * @create 2018-01-12 14:38
 **/
@Entity
@Data
@Table(name = "shop_order", schema = "dsdb")
public class ShopOrderEntity {

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String id;

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String orderNumber;
    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private Double wayCost;
    /**
     * 快递公司编码
     */
    @ApiModelProperty(value = "快递公司编码")
    private String waybillCode;
    /**
     * 运单号
     */
    @ApiModelProperty(value = "运单号")
    private String waybillNumber;
    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号")
    private String transactionNo;
    /**
     * 卖家备注
     */
    @ApiModelProperty(value = "卖家备注")
    private String remarkSeller;
    /**
     * 顾客id
     */
    @ApiModelProperty(value = "顾客id")
    private String customerId;
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private String productId;
    /**
     * 产品规格id
     */
    @ApiModelProperty(value = "产品规格id")
    private String productSpecificationId;
    /**
     * 商品编码
     */
    @ApiModelProperty(value = "商品编码")
    private String productCode;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String productName;
    /**
     * 商品简称
     */
    @ApiModelProperty(value = "商品简称")
    private String productSimplename;
    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Integer productAmount;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private Double price;
    /**
     * 销售属性
     */
    @ApiModelProperty(value = "销售属性")
    private String salesAttribute;
    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String consignee;
    /**
     * 收件人手机
     */
    @ApiModelProperty(value = "收件人手机")
    private String consigneeMobile;
    /**
     * 收件人电话
     */
    @ApiModelProperty(value = "订单号")
    private String consigneeCall;
    /**
     * 应付积分
     */
    @ApiModelProperty(value = "应付积分")
    private Integer amountPayable;
    /**
     * 实付积分
     */
    @ApiModelProperty(value = "实付积分")
    private Integer amountPaid;
    /**
     * 发票抬头
     */
    @ApiModelProperty(value = "发票抬头")
    private String invoiceTitle;
    /**
     * 发票要求
     */
    @ApiModelProperty(value = "发票要求")
    private String invoiceRequest;
    /**
     * 配送方式
     */
    @ApiModelProperty(value = "配送方式")
    private String deliveryType;
    /**
     * 支付状态(0未支付/1已支付,默认为0)
     */
    @ApiModelProperty(value = "支付状态(0未支付/1已支付,默认为0)")
    private Integer payStatus;
    /**
     * 买家留言
     */
    @ApiModelProperty(value = "买家留言")
    private String remarkBuyer;
    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间",dataType = "java.lang.String")
    private Timestamp addTime;
    /**
     * 付款时间
     */
    @ApiModelProperty(value = "付款时间",dataType = "java.lang.String")
    private Timestamp payTime;
    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;
    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;
    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String area;
    /**
     * 收获人详细地址
     */
    @ApiModelProperty(value = "收获人详细地址")
    private String shoppingAddressId;
    /**
     * 收货人邮政编码
     */
    @ApiModelProperty(value = "收货人邮政编码")
    private String consigneeCode;
    /**
     * 物流状态(1未发货,2已发货,3确认收货  默认1)
     */
    @ApiModelProperty(value = "物流状态(1未发货,2已发货,3确认收货  默认1)")
    private Integer deliveryStatus;

    /**
     * 快递公司
     */
    @ApiModelProperty(value = "快递公司")
    private String courierCompany;

    /**
     * 快递单号
     */
    @ApiModelProperty(value = "快递单号")
    private String courierNumber;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_number")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "way_cost")
    public Double getWayCost() {
        return wayCost;
    }

    public void setWayCost(Double wayCost) {
        this.wayCost = wayCost;
    }

    @Basic
    @Column(name = "waybill_code")
    public String getWaybillCode() {
        return waybillCode;
    }

    public void setWaybillCode(String waybillCode) {
        this.waybillCode = waybillCode;
    }

    @Basic
    @Column(name = "waybill_number")
    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    @Basic
    @Column(name = "transaction_no")
    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    @Basic
    @Column(name = "remark_seller")
    public String getRemarkSeller() {
        return remarkSeller;
    }

    public void setRemarkSeller(String remarkSeller) {
        this.remarkSeller = remarkSeller;
    }

    @Basic
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_specification_id")
    public String getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(String productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_simplename")
    public String getProductSimplename() {
        return productSimplename;
    }

    public void setProductSimplename(String productSimplename) {
        this.productSimplename = productSimplename;
    }

    @Basic
    @Column(name = "product_amount")
    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "sales_attribute")
    public String getSalesAttribute() {
        return salesAttribute;
    }

    public void setSalesAttribute(String salesAttribute) {
        this.salesAttribute = salesAttribute;
    }

    @Basic
    @Column(name = "consignee")
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Basic
    @Column(name = "consignee_mobile")
    public String getConsigneeMobile() {
        return consigneeMobile;
    }

    public void setConsigneeMobile(String consigneeMobile) {
        this.consigneeMobile = consigneeMobile;
    }

    @Basic
    @Column(name = "consignee_call")
    public String getConsigneeCall() {
        return consigneeCall;
    }

    public void setConsigneeCall(String consigneeCall) {
        this.consigneeCall = consigneeCall;
    }

    @Basic
    @Column(name = "amount_payable")
    public Integer getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Integer amountPayable) {
        this.amountPayable = amountPayable;
    }

    @Basic
    @Column(name = "amount_paid")
    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Basic
    @Column(name = "invoice_title")
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    @Basic
    @Column(name = "invoice_request")
    public String getInvoiceRequest() {
        return invoiceRequest;
    }

    public void setInvoiceRequest(String invoiceRequest) {
        this.invoiceRequest = invoiceRequest;
    }

    @Basic
    @Column(name = "delivery_type")
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Basic
    @Column(name = "pay_status")
    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "remark_buyer")
    public String getRemarkBuyer() {
        return remarkBuyer;
    }

    public void setRemarkBuyer(String remarkBuyer) {
        this.remarkBuyer = remarkBuyer;
    }

    @Basic
    @Column(name = "add_time")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "pay_time")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "shopping_address_id")
    public String getShoppingAddressId() {
        return shoppingAddressId;
    }

    public void setShoppingAddressId(String shoppingAddressId) {
        this.shoppingAddressId = shoppingAddressId;
    }

    @Basic
    @Column(name = "consignee_code")
    public String getConsigneeCode() {
        return consigneeCode;
    }

    public void setConsigneeCode(String consigneeCode) {
        this.consigneeCode = consigneeCode;
    }

    @Basic
    @Column(name = "delivery_status")
    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Basic
    @Column(name = "courier_company")
    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany;
    }

    @Basic
    @Column(name = "courier_number")
    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }

}
