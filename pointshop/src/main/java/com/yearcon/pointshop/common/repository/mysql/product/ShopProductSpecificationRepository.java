package com.yearcon.pointshop.common.repository.mysql.product;

import com.yearcon.pointshop.moudles.product.entity.ShopProductSpecificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopProductSpecificationRepository extends JpaRepository<ShopProductSpecificationEntity,String> {

    /**
     * 通过商品id查找 商品规格
     * @param productId
     * @return
     */
    List<ShopProductSpecificationEntity> findAllByProductId(String productId);

}
