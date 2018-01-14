package com.yearcon.pointshop.common.repository.mysql.order;

import com.yearcon.pointshop.moudles.order.entity.ShopOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-14 10:59
 **/
public interface ShopOrderRepository extends JpaRepository<ShopOrderEntity,String>{

    List<ShopOrderEntity> findAllByCustomerId(String customerId);

}
