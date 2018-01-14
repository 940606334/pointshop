package com.yearcon.pointshop.shopconfig;

import com.yearcon.pointshop.common.repository.mysql.shopconfig.ShopConfigRepository;
import com.yearcon.pointshop.common.utils.HttpClientUtil;
import com.yearcon.pointshop.common.utils.HttpClientUtil2;
import com.yearcon.pointshop.common.utils.RandomCode;
import com.yearcon.pointshop.moudles.user.entity.ShopConfigEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itguang
 * @create 2018-01-11 8:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopConfigTest {

    @Autowired
    private ShopConfigRepository shopConfigRepository;


    @Autowired
    private RestTemplate restTemplate;





    @Test
    public void test(){

//        List<ShopConfigEntity> list = shopConfigRepository.findAll();
//        log.info("shopConfigEntity==========={}",list.get(0).toString());

        ShopConfigEntity shopConfigEntity = shopConfigRepository.findOne("1");
        log.info("findOne = {}",shopConfigEntity.toString());

//        ShopConfigEntity shopConfigEntity1 = shopConfigRepository.getOne("1");
//        log.info("getOne = {}",shopConfigEntity1.toString());



    }

    @Test
    public void test2() throws URISyntaxException {


         String URL= "http://61.145.229.29:7791/MWGate/wmgw.asmx/MongateSendSubmit";

        Map<String, Object> map = new HashMap<>();
        map.put("userId","H11868");
        map.put("password","332516");
        map.put("pszMobis","17638166573");
        map.put("pszMsg","您正在注册意尔康会员，验证码是：【意尔康】");
        map.put("iMobiCount","1");
        map.put("pszSubPort","*");
        map.put("MsgId",String.valueOf(System.currentTimeMillis()));

        String s = HttpClientUtil2.httpGetRequest(URL, map);

        log.info("response====={}",s);


    }


    @Test
    public void test3(){
        String code = RandomCode.genCode(6);
        log.info("code===={}",code);
    }

}
