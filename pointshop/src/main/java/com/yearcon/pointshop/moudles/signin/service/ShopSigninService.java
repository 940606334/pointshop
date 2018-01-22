package com.yearcon.pointshop.moudles.signin.service;

import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.exception.ShopException;
import com.yearcon.pointshop.common.repository.mysql.signin.ShopSigninConfigRepository;
import com.yearcon.pointshop.common.repository.mysql.signin.ShopSigninRepository;
import com.yearcon.pointshop.common.vo.ShopSigninInfoVO;
import com.yearcon.pointshop.moudles.signin.entity.ShopSigninConfigEntity;
import com.yearcon.pointshop.moudles.signin.entity.ShopSigninEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author itguang
 * @create 2018-01-15 9:23
 **/
@Service
@Slf4j
public class ShopSigninService {

    @Autowired
    ShopSigninRepository shopSigninRepository;

    @Autowired
    ShopCustomerService shopCustomerService;

    @Autowired
    ShopSigninConfigRepository shopSigninConfigRepository;




    public void save(ShopSigninEntity entity){
        ShopSigninEntity save = shopSigninRepository.save(entity);
        if (save==null){
            throw new ShopException(ResultEnum.RECORD_FAIL);

        }
    }


    /**
     * 分页查询签到记录
     *
     * @param startPage 起始页,从1开始
     * @param pageSize  页大小
     * @return
     */
    public List<ShopSigninEntity> findAll(Integer startPage, Integer pageSize,String openid) {

        ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(openid);

        // 按签到时间降序排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "sginDate");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(startPage - 1, pageSize, sort);


        /**
         * root:就是我们要查询的类型 ProductInfoEntity
         * query: 查询条件
         * cb: 构建Predicate(断言)
         *
         */
        Specification<ShopSigninEntity> specification = new Specification<ShopSigninEntity>(){
            @Override
            public Predicate toPredicate(Root<ShopSigninEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("customerId");
                //查询条件:价格大于100
                Predicate predicate = cb.equal(path, customerEntity.getId());

                return predicate;
            }
        };

        Page<ShopSigninEntity> page = shopSigninRepository.findAll(specification,pageable);
        List<ShopSigninEntity> list = page.getContent();

        return list;

    }


    /**
     * 签到
     *
     * @param openid
     * @param type   积分来源类型,签到,消费
     */
    public void sginin(String openid, String type) {

        ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(openid);

        ShopSigninEntity signinEntity = new ShopSigninEntity();


        //设置顾客id
        signinEntity.setCustomerId(customerEntity.getId());

        //设置签到类型
        signinEntity.setType(type);

        //设置签到日期
        signinEntity.setSginDate(new Date(System.currentTimeMillis()));

        //设置此次签到积分值
        signinEntity.setSignPoint(calculatePoint(customerEntity.getId()));

        //设置积分余额(原来余额+此次签到获得的积分)
        signinEntity.setPointBalance(customerEntity.getPoint() + signinEntity.getSignPoint());

        ShopSigninEntity save = shopSigninRepository.save(signinEntity);
        if (save == null) {
            throw new ShopException(ResultEnum.SAVE_SIGNIN_POINT_FAIL);

        }


    }


    /**
     * 计算此次签到获得的积分值
     *
     * @return
     */
    public Integer calculatePoint(String customerId) {

        ShopSigninConfigEntity signinConfigEntity = shopSigninConfigRepository.findOne(1);

        //1 获取今天是周几
        LocalDate localDate = LocalDate.now();
        DayOfWeek week = localDate.getDayOfWeek();
        int weekValue = week.getValue();
        log.info("今天是周{}", weekValue);

        //2. 计算本周的前几天日期
        LocalDate startLocalDate = localDate.minusDays(weekValue);

        //3 查询数据库这几天的签到记录(between)

        Date startDate = Date.valueOf(startLocalDate);
        Date endDate = Date.valueOf(localDate);
        List<ShopSigninEntity> list = shopSigninRepository.findAllByCustomerIdAndTypeAndSginDateBetweenOrderBySginDateAsc(customerId,"签到", startDate, endDate);


        //4. 开始计算本次签到积分值

        List<LocalDate> dates = list.stream()
                .map(ShopSigninEntity::getSginDate)
                .map(date -> date.toLocalDate())
                .collect(toList());

        //零条签到记录
        if (dates.size() == 0) {
            return signinConfigEntity.getOne();

        }

        // 是否重复签到
        LocalDate lastSignin = dates.get(dates.size() - 1);
        if (lastSignin.isEqual(localDate)) {
            throw new ShopException(ResultEnum.SIGNIN_FAIL);
        }

        //如果是周一,则直接返回一天签到值
        if (weekValue == 1) {
            return signinConfigEntity.getOne();
        }


        //是否达到本周签到次数上限
        if (dates.size() == signinConfigEntity.getSigninTimes()) {
            throw new ShopException(ResultEnum.SIGNIN_TIME_FULL);
        }


        //一条签到记录
        if (dates.size() == 1) {
            //连续两天
            if (dates.get(0).isEqual(localDate.minusDays(1))) {
                return signinConfigEntity.getTwo();
            }
            //连续一天
            return signinConfigEntity.getOne();

        }

        // 两条签到记录
        if (dates.size() == 2) {
            //连续三天
            if (dates.get(0).plusDays(1).isEqual(dates.get(1)) && dates.get(1).plusDays(1).isEqual(localDate)) {
                return signinConfigEntity.getThree();
            }
            //连续两天
            if (dates.get(1).plusDays(1).isEqual(localDate)) {
                return signinConfigEntity.getTwo();
            }
            //连续一天
            return signinConfigEntity.getOne();
        }

        //三条签到记录
        if (dates.size() == 3) {
            //如果四天都为连续
            if (dates.get(0).plusDays(1).isEqual(dates.get(1))
                    && dates.get(1).plusDays(1).isEqual(dates.get(2))
                    && dates.get(2).plusDays(1).isEqual(localDate)) {
                return signinConfigEntity.getFour();
            }
            //连续三天
            if (dates.get(1).plusDays(1).isEqual(dates.get(2))
                    && dates.get(2).plusDays(1).isEqual(localDate)) {
                return signinConfigEntity.getThree();

            }
            //连续两天
            if (dates.get(2).plusDays(1).isEqual(localDate)) {
                return signinConfigEntity.getTwo();
            }
            //连续一天
            return signinConfigEntity.getOne();
        }
        return signinConfigEntity.getFour();
    }


    /**
     * 通过openid获取该用户本月签到日期列表
     * @param openid
     * @return
     */
    public List<LocalDate> getSigninDateList(String openid){

        ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(openid);

        String customerId = customerEntity.getId();

        LocalDate now = LocalDate.now();
        int dayOfMonth = now.getDayOfMonth();
        int lengthOfMonth = now.lengthOfMonth();

        LocalDate start = now.minusDays(dayOfMonth - 1);
        LocalDate end = now.plusDays(lengthOfMonth - dayOfMonth);


        List<ShopSigninEntity> list = shopSigninRepository.
                findAllByCustomerIdAndTypeAndSginDateBetweenOrderBySginDateAsc(customerId,"签到", Date.valueOf(start), Date.valueOf(end));

        //总积分
        Integer sum = list.stream().map(ShopSigninEntity::getSignPoint).reduce(0, Integer::sum);

        //本月签到日期
        List<LocalDate> dates = list.stream()
                .map(ShopSigninEntity::getSginDate)
                .map(date -> date.toLocalDate())
                .collect(toList());


        return dates;


    }


    /**
     * 获取签到信息
     *
     * @param openid
     * @return
     */
    public ShopSigninInfoVO info(String openid) {


        ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(openid);

        String customerId = customerEntity.getId();

        LocalDate now = LocalDate.now();
        int dayOfMonth = now.getDayOfMonth();
        int lengthOfMonth = now.lengthOfMonth();

        LocalDate start = now.minusDays(dayOfMonth - 1);
        LocalDate end = now.plusDays(lengthOfMonth - dayOfMonth);


        List<ShopSigninEntity> list = shopSigninRepository.
                findAllByCustomerIdAndSginDateBetweenOrderBySginDateAsc(customerId, Date.valueOf(start), Date.valueOf(end));

        //总积分
        Integer sum = list.stream()
                .filter(entity-> entity.getType().equals("签到"))
                .filter(entity -> entity.getSignPoint()>0)
                .map(ShopSigninEntity::getSignPoint)
                .reduce(0, Integer::sum);

        //本月签到日期
        List<LocalDate> dates = list.stream()
                .filter(entity-> entity.getType().equals("签到"))
                .map(ShopSigninEntity::getSginDate)
                .map(date -> date.toLocalDate())
                .collect(toList());


        ShopSigninInfoVO infoVO = new ShopSigninInfoVO();


        //设置连续签到天数
        infoVO.setDays(getdaysOfMonth(dates));


        //设置本月签到天数
        infoVO.setDaysMonth(dates.size());


        //设置签到获得的总积分
        infoVO.setPoints(sum);


        //设置本月签到日期
        infoVO.setDates(dates);

        return infoVO;
    }

    /**
     * 计算本月连续签到天数
     *
     * @param dates
     * @return
     */
    public Integer getdaysOfMonth(List<LocalDate> dates) {

        int number = 0;

        if (dates.size() == 0) {
            return 0;
        }

        if (dates.size() == 1) {
            return 1;
        }


        for (int i = 0; i < dates.size() - 1; i++) {

            if (dates.get(i).plusDays(1).isEqual(dates.get(i + 1))) {
                number++;
                continue;
            } else {
                number = 1;
                continue;
            }
        }

        int size = dates.size();
        if (dates.get(size - 2).plusDays(1).isEqual(dates.get(size - 1))) {
            number++;

        }

        return number;
    }


}
