package com.yearcon.pointshop.common.repository.mysql.shopconfig;

import com.yearcon.pointshop.moudles.user.entity.ShopConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopConfigRepository extends JpaRepository<ShopConfigEntity,String> {


}
