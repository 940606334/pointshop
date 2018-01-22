package com.yearcon.pointshop.common.repository.mysql.crm;


import com.yearcon.pointshop.moudles.crm.entity.PltJdCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PltJdCustomerRepository extends JpaRepository<PltJdCustomerEntity, String> {

    /**
     * 通过手机号查询所有京东账号
     *
     * @param mobile
     * @return
     */
    public List<PltJdCustomerEntity> findAllByMobile(String mobile);


    /**
     * 通过手机号查询所有京东账号
     *
     * @param mobile
     * @return
     */
    @Query("SELECT\n" +
            "\tt.pin\n" +
            "FROM\n" +
            "\tPltJdCustomerEntity t\n" +
            "WHERE\n" +
            "\tt.mobile = :mobile")
    public List<PltJdCustomerEntity> myfindAllByMobile(@Param("mobile") String mobile);




}
