package com.yearcon.pointshop.moudles.product.web;

import com.yearcon.pointshop.common.anno.LoggerManage;
import com.yearcon.pointshop.common.vo.ShopResult;
import com.yearcon.pointshop.moudles.product.entity.ShopProductEntity;
import com.yearcon.pointshop.moudles.product.entity.ShopProductSpecificationEntity;
import com.yearcon.pointshop.moudles.product.service.ShopProductService;
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
 * @create 2018-01-12 14:51
 **/
@Api(description = "商品管理")
@RestController
@RequestMapping("/product")
public class ShopProductController {

    @Autowired
    ShopProductService shopProductService;


    @ApiOperation(value = "获取商品列表", notes = "分页形式获取商品列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @LoggerManage(logDescription = "获取商品列表")
    public ShopResult<List<ShopProductEntity>> findAll(@ApiParam(value = "起始页") @RequestParam(value = "startPage", defaultValue = "1") Integer startPage,
                                                       @ApiParam(value = "页大小") @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {

        List<ShopProductEntity> list = shopProductService.findAll(startPage, pageSize);

        return ShopResult.success(list);
    }


    @ApiOperation(value = "商品详情", notes = "通过id获取商品详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @LoggerManage(logDescription = "商品详情")
    public ShopResult<ShopProductEntity> findOne(@ApiParam(value = "产品id") @PathVariable(name = "id") String id) {

        ShopProductEntity productEntity = shopProductService.findOne(id);
        return ShopResult.success(productEntity);
    }


    @ApiOperation(value = "获取商品规格信息", notes = "通过商品id获取商品规格参数信息")
    @RequestMapping(value = "/product-specification/{productId}", method = RequestMethod.GET)
    @LoggerManage(logDescription = "获取商品规格信息")
    public ShopResult<List<ShopProductSpecificationEntity>> findAllByProductId(@PathVariable(value = "productId") String productId) {
        List<ShopProductSpecificationEntity> list = shopProductService.findAllByProductId(productId);
        return ShopResult.success(list);
    }


}
