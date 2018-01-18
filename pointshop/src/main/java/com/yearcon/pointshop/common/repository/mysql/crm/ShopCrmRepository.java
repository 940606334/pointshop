package com.yearcon.pointshop.common.repository.mysql.crm;

import com.yearcon.pointshop.moudles.crm.entity.ShopCrmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopCrmRepository extends JpaRepository<ShopCrmEntity,Integer> {

    /**
     *通过openid查找 crm信息
     * @return
     */
    ShopCrmEntity findByOpenid(String openid);


}
