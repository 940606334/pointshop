package com.yearcon.pointshop.moudles.user.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.crm.PltJdCustomerRepository;
import com.yearcon.pointshop.common.repository.mysql.crm.PltTaobaoCustomerRepository;
import com.yearcon.pointshop.common.repository.mysql.shopconfig.ShopConfigRepository;
import com.yearcon.pointshop.common.repository.mysql.user.ShopCodeRepository;
import com.yearcon.pointshop.common.repository.mysql.user.ShopCustomerRepository;
import com.yearcon.pointshop.common.vo.ShopResult;
import com.yearcon.pointshop.common.vo.UserSupplementVO;
import com.yearcon.pointshop.moudles.crm.entity.PltJdCustomerEntity;
import com.yearcon.pointshop.moudles.crm.entity.PltTaobaoCustomerEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopCodeEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopConfigEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

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

    @Autowired
    PltTaobaoCustomerRepository pltTaobaoCustomerRepository;

    @Autowired
    PltJdCustomerRepository pltJdCustomerRepository;


    /**
     * 查找所有用户信息
     *
     * @return
     */
    public List<ShopCustomerEntity> findAll() {


        List<ShopCustomerEntity> list = shopCustomerRepository.findAll();


        return list;
    }


    /**
     * 通过手机号获取 淘宝,京东账号信息
     *
     * @param mobile
     * @return
     */
    public Map<String, List<String>> getAccountByMobile(String mobile) {

        List<PltTaobaoCustomerEntity> taobaoCustomerEntities = pltTaobaoCustomerRepository.findAllByMobile(mobile);

        List<PltJdCustomerEntity> pltJdCustomerEntities = pltJdCustomerRepository.findAllByMobile(mobile);

        List<String> taobaoIds = getTaobaoId(taobaoCustomerEntities);

        List<String> jdIds = getJdId(pltJdCustomerEntities);

        HashMap<String, List<String>> map = new HashMap<>();
        map.put("taobao", taobaoIds);
        map.put("jd", jdIds);


        return map;
    }


    /**
     * 绑定淘宝京东账号
     */
    public void bind(String openid, String type, String account) {

        ShopCustomerEntity customerEntity = findByOpenid(openid);
        if ("taobao".equals(type)) {
            customerEntity.setTaobaoId(account);
            save(customerEntity);
            return;
        }
        if ("jd".equals(type)) {
            customerEntity.setJdId(account);
            save(customerEntity);
            return;
        }

        throw new ShopException(ResultEnum.PARAM_ERROR);


    }


    public List<String> getJdId(List<PltJdCustomerEntity> pltJdCustomerEntities) {

        if (pltJdCustomerEntities.size() == 0) {
           // throw new ShopException(ResultEnum.JD_NO_CUSTOMER);
            return new ArrayList<String>();
        }
        List<String> list = pltJdCustomerEntities.stream()
                .map(PltJdCustomerEntity::getPin)
                .collect(toList());

        return list;

    }


    private List<String> getTaobaoId(List<PltTaobaoCustomerEntity> taobaoCustomerEntities) {

        if (taobaoCustomerEntities.size() == 0) {

            //throw new ShopException(ResultEnum.TAOBAO_NO_CUSTOMER);
            return new ArrayList<String>();

        }

        List<String> list = taobaoCustomerEntities.stream()
                .map(PltTaobaoCustomerEntity::getCustomerno)
                .collect(toList());


        return list;
    }


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

        //设置京东账号
        customerEntity.setJdId(userSupplementVO.getJdId());

        //设置性别
         customerEntity.setSex(userSupplementVO.getSex());

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
