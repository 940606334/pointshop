package com.yearcon.pointshop.common.repository.mysql.crm;

import com.yearcon.pointshop.moudles.crm.entity.PltTaobaoCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PltTaobaoCustomerRepository extends JpaRepository<PltTaobaoCustomerEntity, String> {


    /**
     * 通过手机号查询所有淘宝账号
     *
     * @param mobile
     * @return
     */
    List<PltTaobaoCustomerEntity> findAllByMobile(String mobile);


    /**
     * 通过手机号查询所有淘宝账号
     *
     * @param mobile
     * @return
     */
    @Query("SELECT\n" +
            "\tt.customerno\n" +
            "FROM\n" +
            "\tPltTaobaoCustomerEntity t\n" +
            "WHERE\n" +
            "\tt.mobile = :mobile")
    List<PltTaobaoCustomerEntity> myfindAllByMobile(@Param("mobile") String mobile);




}
