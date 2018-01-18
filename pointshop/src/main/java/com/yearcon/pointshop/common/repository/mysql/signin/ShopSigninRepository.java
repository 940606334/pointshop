package com.yearcon.pointshop.common.repository.mysql.signin;

import com.yearcon.pointshop.moudles.signin.entity.ShopSigninEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.sql.Date;
import java.util.List;

/**
 * @author itguang
 * @create 2018-01-15 9:30
 **/
public interface ShopSigninRepository extends JpaRepository<ShopSigninEntity,Integer>,JpaSpecificationExecutor<ShopSigninEntity> {


    /**
     * 通过用户id查找某用户一段时间内的签到记录,并按时间升序排序
     * @param customerId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ShopSigninEntity> findAllByCustomerIdAndSginDateBetweenOrderBySginDateAsc(String customerId, Date startDate, Date endDate);


    /**
     * 通过 customerID 查找本月所有的签到信息
     * @param customerId
     * @return
     */
    List<ShopSigninEntity> findAllByCustomerId(String customerId);



}
