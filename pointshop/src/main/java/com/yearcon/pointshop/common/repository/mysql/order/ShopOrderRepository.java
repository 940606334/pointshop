package com.yearcon.pointshop.common.repository.mysql.order;

import com.yearcon.pointshop.moudles.order.entity.ShopOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-14 10:59
 **/
public interface ShopOrderRepository extends JpaRepository<ShopOrderEntity,String>{

    List<ShopOrderEntity> findAllByCustomerId(String customerId);


    @Query("SELECT\n" +
            "\to\n" +
            "FROM\n" +
            "\tShopOrderEntity o\n" +
            "WHERE\n" +
            "\to.customerId = :customerId\n" +
            "ORDER BY\n" +
            "\to.payTime DESC")
    List<ShopOrderEntity> findAllShopOrderEntity(@Param("customerId") String customerId);

}
