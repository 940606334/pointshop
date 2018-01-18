package com.yearcon.pointshop.common.repository.mysql.address;

import com.yearcon.pointshop.moudles.address.entity.ShopShippingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author itguang
 * @creat 2018-01-12 16:54
 **/
public interface ShopShippingAddressRepository extends JpaRepository<ShopShippingAddressEntity, String> {


    /**
     * 通过openid找到对应的地址列表
     *
     * @param openid
     * @return
     */
    List<ShopShippingAddressEntity> findAllByOpenid(String openid);

    /**
     * 找到默认的收货地址
     *
     * @param isDefault
     * @return
     */
    ShopShippingAddressEntity findByIsDefault(Integer isDefault);

    /**
     * 通过 customerId 查找所有的收货地址
     *
     * @param customerId
     * @return
     */
    List<ShopShippingAddressEntity> findAllByCustomerId(String customerId);


    /**
     * 通过 customerId 查找所有的收货地址
     *
     * @param isDefault
     * @return
     */
    ShopShippingAddressEntity findAllByIsDefault(Integer isDefault);





}
