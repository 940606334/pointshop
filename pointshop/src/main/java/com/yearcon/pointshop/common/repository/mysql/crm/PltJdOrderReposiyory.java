package com.yearcon.pointshop.common.repository.mysql.crm;

import com.yearcon.pointshop.moudles.crm.entity.PltJdOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PltJdOrderReposiyory extends JpaRepository<PltJdOrderEntity,String> {

    /**
     * 通过京东id查找所有订单
     * @param pin
     * @return
     */
    List<PltJdOrderEntity> findAllByPin(String pin);


    /**
     * 通过京东id查找所有订单
     * @param pin
     * @return
     */
    @Query("SELECT\n" +
            "\to.orderSellerPrice,\n" +
            "\to.orderEndTime\n" +
            "FROM\n" +
            "\tPltJdOrderEntity o\n" +
            "WHERE\n" +
            "\to.pin = :pin")
    List<PltJdOrderEntity> myfindAllByPin(@Param("pin") String pin);






}
