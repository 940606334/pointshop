package com.yearcon.pointshop.address;

import com.yearcon.pointshop.common.utils.Identities;
import com.yearcon.pointshop.moudles.address.entity.ShopShippingAddressEntity;
import com.yearcon.pointshop.moudles.address.service.ShopShippingAddressService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-14 8:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShopShippingAddressTest {

    @Autowired
    ShopShippingAddressService shippingAddressService;




    @Test
    public void  save(){
        ShopShippingAddressEntity shopShippingAddressEntity = new ShopShippingAddressEntity();
        shopShippingAddressEntity.setId(Identities.uuid2());
        shippingAddressService.save(shopShippingAddressEntity);

    }

    @Test
    public void delete(){
        shippingAddressService.delete("6fe8eb1607a24f7dbebcc20cd7ae0bb9");
    }

    @Test
    public void setDefault(){
        shippingAddressService.setDefault("3c82438eb7a7469b99525f94aa0359b6");
    }

    @Test
    public void findAllByOpenid(){
        List<ShopShippingAddressEntity> list = shippingAddressService.findAllByOpenid("123");
        log.info("list={}",list.toString());
    }




}
