package com.yearcon.pointshop.moudles.schedule.service;

import com.yearcon.pointshop.common.repository.mysql.crm.PltJdOrderReposiyory;
import com.yearcon.pointshop.common.repository.mysql.crm.PltTaobaoOrderRepository;
import com.yearcon.pointshop.moudles.crm.entity.PltJdOrderEntity;
import com.yearcon.pointshop.moudles.crm.entity.PltTaobaoOrderEntity;
import com.yearcon.pointshop.moudles.crm.entity.ShopCrmEntity;
import com.yearcon.pointshop.moudles.crm.entity.ShopVipClassConfigEntity;
import com.yearcon.pointshop.moudles.crm.service.ShopCrmService;
import com.yearcon.pointshop.moudles.crm.service.ShopVipClassConfigService;
import com.yearcon.pointshop.moudles.signin.entity.ShopSigninEntity;
import com.yearcon.pointshop.moudles.signin.service.ShopSigninService;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.rmi.runtime.Log;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 定时同步Crm订单数据
 *
 * @author itguang
 * @create 2018-01-20 10:42
 **/
@Component
@Slf4j
public class CrmTask {

    @Autowired
    PltTaobaoOrderRepository pltTaobaoOrderRepository;

    @Autowired
    PltJdOrderReposiyory pltJdOrderReposiyory;

    @Autowired
    ShopCustomerService shopCustomerService;

    @Autowired
    ShopCrmService shopCrmService;

    @Autowired
    ShopVipClassConfigService shopVipClassConfigService;

    @Autowired
    ShopSigninService shopSigninService;


    /**
     * 每天的 凌晨1:00 开始执行同步淘宝消费记录
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void taobao() {

        log.info("【每天的 凌晨1:00 开始执行同步淘宝消费记录 开始】");

        List<ShopCustomerEntity> customerEntities = shopCustomerService.findAll();
        List<ShopVipClassConfigEntity> classConfigEntityList = shopVipClassConfigService.getConfig();

        for (ShopCustomerEntity shopCustomerEntity : customerEntities) {

            if (!StringUtils.isEmpty(shopCustomerEntity.getTaobaoId())) {
                List<PltTaobaoOrderEntity> list = pltTaobaoOrderRepository.findAllByCustomerno(shopCustomerEntity.getTaobaoId());

                //1 计算总金额
                Double sum = list.stream()
                        .map(PltTaobaoOrderEntity::getPayment)
                        .reduce(0.0, Double::sum);

                //把金额存到shop_crm表中
                ShopCrmEntity crmEntity = shopCrmService.getByOpenid(shopCustomerEntity.getOpenid());

                if(crmEntity==null){
                    crmEntity = new ShopCrmEntity();
                    crmEntity.setOpenid(shopCustomerEntity.getOpenid());

                }

                //如果金额增加,需要加上相应积分值,包括 积分记录
                if (sum > crmEntity.getTaobao()) {
                    //加上消费增加的积分值
                    int point = getPointByConfig(classConfigEntityList, sum - crmEntity.getTaobao());
                    shopCustomerEntity.setPoint(point + shopCustomerEntity.getPoint());
                    //保存
                    shopCustomerService.save(shopCustomerEntity);

                    //添加积分变更记录
                    saveSigninRecord(shopCustomerEntity, point, "淘宝购物");


                }
                //变更淘宝消费金额
                crmEntity.setTaobao(sum);

                //根据总金额设置会员等级
                crmEntity.setVipClass(getVipVlassByConfig(classConfigEntityList, sum));

                //更新日期
                crmEntity.setUpdateDate(new Date(System.currentTimeMillis()));

                //保存 ShopCrmEntity
                shopCrmService.save(crmEntity);


            }


        }
        log.info("【每天的 凌晨1:00 开始执行同步淘宝消费记录 结束】");


    }

    /**
     * 每天的 凌晨2:00 开始执行同步京东消费记录
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void jd() {

        log.info("【每天的 凌晨2:00 开始执行同步京东消费记录 开始】");

        List<ShopCustomerEntity> customerEntities = shopCustomerService.findAll();
        List<ShopVipClassConfigEntity> classConfigEntityList = shopVipClassConfigService.getConfig();
        for (ShopCustomerEntity shopCustomerEntity : customerEntities) {

            if (!StringUtils.isEmpty(shopCustomerEntity.getJdId())) {
                List<PltJdOrderEntity> list = pltJdOrderReposiyory.findAllByPin(shopCustomerEntity.getJdId());

                //1 计算总金额
                Double sum = list.stream()
                        .map(PltJdOrderEntity::getOrderSellerPrice)
                        .reduce(0.0, Double::sum);

                //把金额存到shop_crm表中
                ShopCrmEntity crmEntity = shopCrmService.getByOpenid(shopCustomerEntity.getOpenid());

                if(crmEntity==null){
                    crmEntity = new ShopCrmEntity();
                    crmEntity.setOpenid(shopCustomerEntity.getOpenid());

                }
                //如果金额增加,需要加上相应积分值,包括 积分记录
                if (sum > crmEntity.getJd()) {
                    //加上消费增加的积分值
                    int point = getPointByConfig(classConfigEntityList, sum - crmEntity.getJd());
                    shopCustomerEntity.setPoint(point + shopCustomerEntity.getPoint());
                    shopCustomerService.save(shopCustomerEntity);

                    //添加积分变更记录
                    saveSigninRecord(shopCustomerEntity, point, "京东购物");


                }
                //变更京东消费金额
                crmEntity.setJd(sum);

                //更新日期
                crmEntity.setUpdateDate(new Date(System.currentTimeMillis()));

                //根据总金额设置会员等级
                crmEntity.setVipClass(getVipVlassByConfig(classConfigEntityList, sum));

                //保存 ShopCrmEntity
                shopCrmService.save(crmEntity);


            }


        }
        log.info("【每天的 凌晨2:00 开始执行同步京东消费记录 结束】");

    }

    /**
     * 计算金额对应的积分换算
     *
     * @param list 配置列表
     * @param sum  最新增加的消费金额
     * @return 最近消费金额兑换的积分值
     */
    public int getPointByConfig(List<ShopVipClassConfigEntity> list, Double sum) {

        //至尊会员
        if (sum >= list.get(0).getUpgradeCondition()) {
            double point = sum * list.get(0).getConvertPoint();
            return (int) point;
        }
        //黄金会员
        if (sum >= list.get(1).getUpgradeCondition()) {
            double point = sum * list.get(1).getConvertPoint();
            return (int) point;
        }
        //白金会员
        if (sum >= list.get(2).getUpgradeCondition()) {
            double point = sum * list.get(2).getConvertPoint();
            return (int) point;
        }


        //普通会员
        double point = sum * list.get(3).getConvertPoint();
        return (int) point;

    }


    /**
     * 根据总消费金额计算会员等级
     *
     * @param list
     * @param sum
     * @return 返回目前总金额对应的会员等级
     */
    public String getVipVlassByConfig(List<ShopVipClassConfigEntity> list, Double sum) {

        for (int i = 0; i < list.size(); i++) {
            if (sum >= list.get(i).getUpgradeCondition()) {
                return list.get(i).getVipClassName();
            }

        }


        return "";
    }


    public ShopSigninEntity saveSigninRecord(ShopCustomerEntity shopCustomerEntity, Integer addPoint, String note) {

        ShopSigninEntity shopSigninEntity = new ShopSigninEntity();
        shopSigninEntity.setCustomerId(shopCustomerEntity.getId());
        shopSigninEntity.setSignPoint(addPoint);
        shopSigninEntity.setPointBalance(shopCustomerEntity.getPoint() + addPoint);
        LocalDate localDate = LocalDate.now().minusDays(1);
        shopSigninEntity.setSginDate(Date.valueOf(localDate));

        return shopSigninEntity;

    }





}
