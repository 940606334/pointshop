package com.yearcon.pointshop.moudles.user.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.shopconfig.ShopConfigRepository;
import com.yearcon.pointshop.common.repository.mysql.user.ShopCodeRepository;
import com.yearcon.pointshop.common.repository.mysql.user.ShopCustomerRepository;
import com.yearcon.pointshop.common.vo.UserSupplementVO;
import com.yearcon.pointshop.moudles.user.entity.ShopCodeEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopConfigEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 积分商城 顾客 service
 *
 * @author itguang
 * @create 2018-01-10 15:19
 **/
@Service
public class ShopCustomerService {

    @Autowired
    ShopCustomerRepository shopCustomerRepository;

    @Autowired
    ShopConfigRepository shopConfigRepository;

    @Autowired
    ShopCodeRepository shopCodeRepository;


    /**
     * 通过 openid 查找顾客信息
     *
     * @param openid
     * @return
     */
    public ShopCustomerEntity findByOpenid(String openid) {
        ShopCustomerEntity shopCustomerEntity = shopCustomerRepository.findByOpenid(openid);
        if (shopCustomerEntity == null) {
            throw new ShopException(ResultEnum.NOT_EXIST);

        }
        return shopCustomerEntity;
    }

    /**
     * 保存顾客信息
     *
     * @param shopCustomerEntity
     */
    public ShopCustomerEntity save(ShopCustomerEntity shopCustomerEntity) {
        ShopCustomerEntity one = shopCustomerRepository.save(shopCustomerEntity);
        if (one == null) {
            throw new ShopException(ResultEnum.SAVE_CUSTOMER_FAIL);
        }

        return one;
    }


    public ShopCustomerEntity findOne(String customerId) {
        ShopCustomerEntity customerEntity = shopCustomerRepository.findOne(customerId);

        if (customerEntity == null) {
            throw new ShopException(ResultEnum.NOT_EXIST);

        }

        return customerEntity;

    }

    /**
     * 完善户信息
     *
     * @param openid
     * @param userSupplementVO
     */
    public void info(String openid, UserSupplementVO userSupplementVO) {

        ShopCustomerEntity customerEntity = shopCustomerRepository.findByOpenid(openid);
        if (customerEntity == null) {
            throw new ShopException(ResultEnum.NOT_EXIST);
        }

        //设置用户信息

        //设置手机号
        //  customerEntity.setPhone(userSupplementVO.getPhone());

        //设置姓名
        customerEntity.setUsername(userSupplementVO.getUsername());

        //设置淘宝号
        customerEntity.setTaobaoId(userSupplementVO.getTaobaoId());

        //设置性别
        // customerEntity.setSex(userSupplementVO.getSex());

        //设置生日
        customerEntity.setBirthday(userSupplementVO.getBirthday());

        //设置地址
        customerEntity.setAddress(userSupplementVO.getAddress());

        //设置尺码
        customerEntity.setSize(userSupplementVO.getSize());

        ShopCustomerEntity save = shopCustomerRepository.save(customerEntity);
        if (save == null) {
            throw new ShopException(ResultEnum.SAVE_CUSTOMER_FAIL);

        }
    }


    public ShopConfigEntity getShopConfigEntity() {

        ShopConfigEntity one = shopConfigRepository.findOne("1");
        if (one == null) {

            throw new ShopException(ResultEnum.CONFIG_NOT_EXIST);
        }

        return one;
    }

    public void saveShopCodeEntity(String phone, String code) {

        ShopCodeEntity shopCodeEntity = shopCodeRepository.findOneByPhone(phone);
        if (shopCodeEntity != null) {
            shopCodeEntity.setPhone(phone);
            shopCodeEntity.setCode(code);
            shopCodeRepository.save(shopCodeEntity);
            return;
        }
        ShopCodeEntity save = shopCodeRepository.save(new ShopCodeEntity(code, phone));
        if (save == null) {

            throw new ShopException(ResultEnum.SAVE_CODE_FAIL);
        }
    }


    public String findByPhone(String phone) {
        ShopCodeEntity shopCodeEntity = shopCodeRepository.findOneByPhone(phone);
        if (shopCodeEntity == null) {
            return "";
        }
        return shopCodeEntity.getCode();
    }


}
