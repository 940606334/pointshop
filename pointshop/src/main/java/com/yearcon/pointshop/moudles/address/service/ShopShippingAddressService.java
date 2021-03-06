package com.yearcon.pointshop.moudles.address.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.address.ShopShippingAddressRepository;
import com.yearcon.pointshop.common.utils.Identities;
import com.yearcon.pointshop.moudles.address.entity.ShopShippingAddressEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author itguang
 * @create 2018-01-14 8:05
 **/
@Service
public class ShopShippingAddressService {

    @Autowired
    ShopShippingAddressRepository shippingAddressRepository;

    @Autowired
    ShopCustomerService shopCustomerService;


    public ShopShippingAddressEntity findOne(String id) {
        ShopShippingAddressEntity one = shippingAddressRepository.findOne(id);
        if (one == null) {
            throw new ShopException(ResultEnum.ADDRESS_NOT_EXIST);

        }

        return one;

    }


    /**
     * 通过openid 查找对应的收货地址
     *
     * @param openid
     * @return
     */
    public List<ShopShippingAddressEntity> findAllByOpenid(String openid) {
        List<ShopShippingAddressEntity> list = shippingAddressRepository.findAllByOpenid(openid);
        if (list.size() < 1) {
            throw new ShopException(ResultEnum.ADDRESS_NOT_FIND);

        }
        return list;

    }


    /**
     * 保存 收货地址
     *
     * @param entity
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void save(ShopShippingAddressEntity entity) {

        entity.setId(Identities.uuid2());

        ShopShippingAddressEntity shippingAddressEntity = shippingAddressRepository.save(entity);


    }

    /**
     * 修改 收货地址
     *
     * @param entity
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(ShopShippingAddressEntity entity) {


        //  ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(entity.getOpenid());

        // entity.setCustomerId(customerEntity.getId());

        ShopShippingAddressEntity shippingAddressEntity = shippingAddressRepository.save(entity);


    }


    /**
     * 通过 收货地址id 删除该地址
     *
     * @param addressId 收货地址id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(String addressId) {

        ShopShippingAddressEntity one = shippingAddressRepository.findOne(addressId);
        if (one == null) {
            throw new ShopException(ResultEnum.ADDRESS_NOT_EXIST);

        }


        shippingAddressRepository.delete(addressId);

    }


    /**
     * 设置默认收货地址
     *
     * @param addressId 收货地址id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void setDefault(String addressId) {

        //重新设置默认地址,设置之前要把之前的默认地址取消掉
        ShopShippingAddressEntity shippingAddressEntity = shippingAddressRepository.findOne(addressId);

        ShopShippingAddressEntity defaultEntity = shippingAddressRepository.findAllByIsDefault(1);

        if(defaultEntity!=null){

            defaultEntity.setIsDefault(0);
            update(defaultEntity);
        }


        shippingAddressEntity.setIsDefault(1);
        update(shippingAddressEntity);

    }
}


