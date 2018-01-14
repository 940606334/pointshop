package com.yearcon.pointshop.moudles.address.web;

import com.yearcon.pointshop.common.vo.ShopResult;
import com.yearcon.pointshop.moudles.address.entity.ShopShippingAddressEntity;
import com.yearcon.pointshop.moudles.address.service.ShopShippingAddressService;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author itguang
 * @create 2018-01-14 9:14
 **/
@Api(description = "收货地址管理")
@RestController
@RequestMapping("/address")
public class ShopShippingAddressController {

    @Autowired
    ShopShippingAddressService shippingAddressService;

    @Autowired
    ShopCustomerService shopCustomerService;



    @ApiOperation(value = "获取用户收货地址列表",notes = "通过openid获取改用户所有收货地址列表")
    @RequestMapping(value = "/{openid}",method = RequestMethod.GET)
    public ShopResult<List<ShopShippingAddressEntity>> getList(@PathVariable("openid") String openid){
        List<ShopShippingAddressEntity> list = shippingAddressService.findAllByOpenid(openid);


        return ShopResult.success(list);
    }


    @ApiOperation(value = "增加收货地址", notes = "增加一个收货地址,id 字段非必须")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ShopResult save(@RequestParam(value = "shippingAddressEntity") ShopShippingAddressEntity shippingAddressEntity) {

        ShopCustomerEntity customerEntity = shopCustomerService.findByOpenid(shippingAddressEntity.getOpenid());
        shippingAddressEntity.setCustomerId(customerEntity.getId());

        shippingAddressService.save(shippingAddressEntity);


        return ShopResult.success();
    }


    @ApiOperation(value = "修改收货地址", notes = "修改收货地址,所有字段都为必须")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ShopResult update(@RequestParam(value = "shippingAddressEntity") ShopShippingAddressEntity shippingAddressEntity) {

        shippingAddressService.save(shippingAddressEntity);
        return ShopResult.success();
    }


    @ApiOperation(value = "删除一个收货地址", notes = "根据收货地址id删除一个收货地址")
    @RequestMapping(value = "/delete/{addressId}", method = RequestMethod.GET)
    public ShopResult delete(@PathVariable("addressId") String addressId) {
        shippingAddressService.delete(addressId);

        return ShopResult.success();
    }

    @ApiOperation(value = "设置默认收货地址", notes = "设置默认收货地址,参数:收货地址id")
    @RequestMapping(value = "/set-default-address/{addressId}", method = RequestMethod.GET)
    public ShopResult setDefault(@ApiParam("收货地址id") @PathVariable("addressId") String addressID) {

        shippingAddressService.setDefault(addressID);
        return ShopResult.success();

    }




}
