package com.yearcon.pointshop.common.repository.mysql.crm;

import com.yearcon.pointshop.moudles.crm.entity.PltTaobaoOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PltTaobaoOrderRepository extends JpaRepository<PltTaobaoOrderEntity,String> {


    /**
     * 通过淘宝id查询订单信息
     * @param customerno
     * @return
     */
    List<PltTaobaoOrderEntity> findAllByCustomerno(String customerno);



    /**
     * 通过淘宝id查询订单信息
     * @param customerno
     * @return
     */
    @Query("SELECT\n" +
            "\to.payment,\n" +
            "\to.payTime\n" +
            "FROM\n" +
            "\tPltTaobaoOrderEntity o\n" +
            "WHERE\n" +
            "\to.customerno = :customerno")
    List<PltTaobaoOrderEntity> myfindAllByCustomerno(@Param("customerno") String customerno);




}
