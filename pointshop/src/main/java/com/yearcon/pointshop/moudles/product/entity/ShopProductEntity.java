package com.yearcon.pointshop.moudles.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @create 2018-01-12 14:37
 **/
@Entity
@Data
@Table(name = "shop_product", schema = "dsdb")
public class ShopProductEntity {
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private String id;
    /**
     *产品货号
     */
    @ApiModelProperty(value = "产品货号")
    private String productNo;
    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;
    /**
     *产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String name;
    /**
     * 上市年份
     */
    @ApiModelProperty(value = "上市年份")
    private String marketDate;
    /**
     * 分类表id
     */
    @ApiModelProperty(value = "分类表id")
    private String categoryId;
    /**
     * 访问量
     */
    @ApiModelProperty(value = "访问量")
    private Integer visits;
    /**
     *产品分类
     */
    @ApiModelProperty(value = "产品分类")
    private String productType;
    /**
     * 场合
     */
    @ApiModelProperty(value = "场合")
    private String occasion;
    /**
     *款式
     */
    @ApiModelProperty(value = "款式")
    private String size;
    /**
     *风格
     */
    @ApiModelProperty(value = "风格")
    private String style;
    /**
     *功能
     */
    @ApiModelProperty(value = "功能")
    private String function;
    /**
     *适用对象
     */
    @ApiModelProperty(value = "适用对象")
    private String target;
    /**
     *鞋面内里材质
     */
    @ApiModelProperty(value = "鞋面内里材质")
    private String vampTexture;
    /**
     *低帮鞋品名
     */
    @ApiModelProperty(value = "低帮鞋品名")
    private String lowShoesName;
    /**
     *鞋垫材质
     */
    @ApiModelProperty(value = "鞋垫材质")
    private String insoleTexture;
    /**
     *排序值
     */

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Integer sortNo;
    /**
     *关键词
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String keyword;
    /**
     *产品摘要
     */
    @ApiModelProperty(value = "产品摘要")
    private String summary;
    /**
     *上架数量
     */
    @ApiModelProperty(value = "上架数量")
    private Integer stores;
    /**
     *零售价
     */
    @ApiModelProperty(value = "零售价")
    private Double price;
    /**
     *产品积分
     */
    @ApiModelProperty(value = "产品积分")
    private Integer points;
    /**
     *产品描述
     */
    @ApiModelProperty(value = "产品描述")
    private String description;
    /**
     *产品详情
     */
    @ApiModelProperty(value = "产品详情")
    private String details;
    /**
     *销量
     */
    @ApiModelProperty(value = "销量")
    private Integer sales;
    /**
     *产品剩余
     */
    @ApiModelProperty(value = "产品剩余")
    private Integer residue;
    /**
     *是否新品(0否/1是  默认0)
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Integer isNew;
    /**
     *是否热门(0否/1是 默认为0)
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Integer isHot;
    /**
     *上下架状态(0否/1是 默认1)
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Integer isAlive;
    /**
     *产品图片/轮播图1
     */
    @ApiModelProperty(value = "产品图片/轮播图1")
    private String pictureUrlDefault;
    /**
     * 轮播图2
     */
    @ApiModelProperty(value = "轮播图2")
    private String pictureUrl2;
    /**
     *轮播图3
     */
    @ApiModelProperty(value = "轮播图3")
    private String pictureUrl3;
    /**
     *轮播图4
     */
    @ApiModelProperty(value = "轮播图4")
    private String pictureUrl4;
    /**
     *轮播图5
     */
    @ApiModelProperty(value = "轮播图5")
    private String pictureUrl5;
    /**
     *轮播图6
     */
    @ApiModelProperty(value = "轮播图6")
    private String pictureUrl6;

    /**
     *添加日期
     */
    @ApiModelProperty(value = "添加日期",dataType = "java.lang.String")
    private Timestamp addTime;

    /**
     *开始 产品积分
     */
    @ApiModelProperty(value = "开始 产品积分")
    private Integer beginPoints;
    /**
     *结束 产品积分
     */
    @ApiModelProperty(value = "开始 产品积分")
    private Integer endPoints;



    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_no")
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "market_date")
    public String getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(String marketDate) {
        this.marketDate = marketDate;
    }

    @Basic
    @Column(name = "category_id")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "visits")
    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "occasion")
    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Basic
    @Column(name = "function")
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Basic
    @Column(name = "target")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "vamp_texture")
    public String getVampTexture() {
        return vampTexture;
    }

    public void setVampTexture(String vampTexture) {
        this.vampTexture = vampTexture;
    }

    @Basic
    @Column(name = "low_shoes_name")
    public String getLowShoesName() {
        return lowShoesName;
    }

    public void setLowShoesName(String lowShoesName) {
        this.lowShoesName = lowShoesName;
    }

    @Basic
    @Column(name = "insole_texture")
    public String getInsoleTexture() {
        return insoleTexture;
    }

    public void setInsoleTexture(String insoleTexture) {
        this.insoleTexture = insoleTexture;
    }

    @Basic
    @Column(name = "sort_no")
    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    @Basic
    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "stores")
    public Integer getStores() {
        return stores;
    }

    public void setStores(Integer stores) {
        this.stores = stores;
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
    @Column(name = "points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "sales")
    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "residue")
    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

    @Basic
    @Column(name = "is_new")
    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    @Basic
    @Column(name = "is_hot")
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    @Basic
    @Column(name = "is_alive")
    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

    @Basic
    @Column(name = "picture_url_default")
    public String getPictureUrlDefault() {
        return pictureUrlDefault;
    }

    public void setPictureUrlDefault(String pictureUrlDefault) {
        this.pictureUrlDefault = pictureUrlDefault;
    }

    @Basic
    @Column(name = "picture_url2")
    public String getPictureUrl2() {
        return pictureUrl2;
    }

    public void setPictureUrl2(String pictureUrl2) {
        this.pictureUrl2 = pictureUrl2;
    }

    @Basic
    @Column(name = "picture_url3")
    public String getPictureUrl3() {
        return pictureUrl3;
    }

    public void setPictureUrl3(String pictureUrl3) {
        this.pictureUrl3 = pictureUrl3;
    }

    @Basic
    @Column(name = "picture_url4")
    public String getPictureUrl4() {
        return pictureUrl4;
    }

    public void setPictureUrl4(String pictureUrl4) {
        this.pictureUrl4 = pictureUrl4;
    }

    @Basic
    @Column(name = "picture_url5")
    public String getPictureUrl5() {
        return pictureUrl5;
    }

    public void setPictureUrl5(String pictureUrl5) {
        this.pictureUrl5 = pictureUrl5;
    }

    @Basic
    @Column(name = "picture_url6")
    public String getPictureUrl6() {
        return pictureUrl6;
    }

    public void setPictureUrl6(String pictureUrl6) {
        this.pictureUrl6 = pictureUrl6;
    }

    @Basic
    @Column(name = "add_time")
    @ApiModelProperty(hidden = true)
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "begin_points")
    public Integer getBeginPoints() {
        return beginPoints;
    }

    public void setBeginPoints(Integer beginPoints) {
        this.beginPoints = beginPoints;
    }

    @Basic
    @Column(name = "end_points")
    public Integer getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(Integer endPoints) {
        this.endPoints = endPoints;
    }



}
