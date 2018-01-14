package com.yearcon.pointshop.moudles.product.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author itguang
 * @create 2018-01-12 15:16
 **/
@Entity
@Data
@Table(name = "shop_product_specification", schema = "dsdb")
public class ShopProductSpecificationEntity {
    private String id;
    private String productId;
    private String name;
    private Integer inventory;
    private Integer needIntegration;
    private String color;
    private String colorName;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "inventory")
    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "need_integration")
    public Integer getNeedIntegration() {
        return needIntegration;
    }

    public void setNeedIntegration(Integer needIntegration) {
        this.needIntegration = needIntegration;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "color_name")
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

}
