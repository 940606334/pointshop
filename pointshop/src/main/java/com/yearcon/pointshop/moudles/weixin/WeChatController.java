package com.yearcon.pointshop.moudles.weixin;

import com.yearcon.pointshop.common.anno.LoggerManage;
import com.yearcon.pointshop.common.config.security.TokenAuthenticationService;
import com.yearcon.pointshop.common.enums.ResultEnum;
import com.yearcon.pointshop.common.repository.mysql.shopconfig.ShopConfigRepository;
import com.yearcon.pointshop.common.repository.mysql.user.ShopCustomerRepository;
import com.yearcon.pointshop.common.utils.Identities;
import com.yearcon.pointshop.common.vo.ShopResult;
import com.yearcon.pointshop.moudles.user.entity.ShopConfigEntity;
import com.yearcon.pointshop.moudles.user.entity.ShopCustomerEntity;
import com.yearcon.pointshop.moudles.user.service.ShopConfigService;
import com.yearcon.pointshop.moudles.user.service.ShopCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itguang
 * @create 2018-01-10 13:28
 **/
@Controller
@Slf4j
@RequestMapping("/weixin")
@Api(description = "微信授权")
public class WeChatController {

    @Autowired
    private ShopConfigService shopConfigService;

    @Autowired
    private ShopCustomerService shopCustomerService;

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;

    @Autowired
    ShopCustomerRepository shopCustomerRepository;

    /**
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @ApiOperation(value = "微信网页授权", notes = "必须在微信客户端打开此链接. 如果已经注册过手机号则跳转到首页. 没有注册过跳转到注册页面")
    @RequestMapping(value = "/authorize", method = RequestMethod.GET)

    public String authorize(HttpServletRequest request, @RequestParam("indexUrl") String indexUrl) throws UnsupportedEncodingException {

        //1.得到请求的 服务器域名
        String serverName = request.getServerName();
        log.info("serverName={}", serverName);

        //  从数据库查找 appid 和 secret
        ShopConfigEntity shopConfigEntity = shopConfigService.findConfig();
        wxMpInMemoryConfigStorage.setAppId(shopConfigEntity.getAppid());
        wxMpInMemoryConfigStorage.setSecret(shopConfigEntity.getSecret());
        wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);

        String redirectURI ="http://dsjfcrm.yearcon.com"+ "/shop/weixin/userInfo";
//        String redirectURI = "http://" + serverName + "/shop/weixin/userInfo";

        String index = URLEncoder.encode(indexUrl, "utf-8");

        //构造网页授权url
        String url = wxMpService.oauth2buildAuthorizationUrl(redirectURI, WxConsts.OAUTH2_SCOPE_USER_INFO, index);

        return "redirect:" + url;
    }

    /**
     * 微信网页授权 回调 url
     *
     * @param code 微信返回的code码,用来获取 微信凭据,只能使用一次.
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(HttpServletResponse response,
                           HttpServletRequest request,
                           @RequestParam("code") String code,
                           @RequestParam("state") String indexUrl,
                           HttpSession httpSession) {

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");

        log.info("code={},indexUrl={}", code, indexUrl);


        //2.获得accesstoken()
        WxMpUser wxMpUser = null;
        try {
            WxMpOAuth2AccessToken auth2AccessToken = wxMpService.oauth2getAccessToken(code);
            wxMpUser = wxMpService.oauth2getUserInfo(auth2AccessToken, null);
        } catch (WxErrorException e) {
            log.error("[微信网页授权] 授权失败:={}", e.getError().getErrorMsg());

        }

        log.info("wxMpUser={}", wxMpUser.toString());

        //  获取微信 openId, 头像地址 , 昵称 等
        String openid = wxMpUser.getOpenId();

//        查询 该 openid 是否存在数据库中.
        ShopCustomerEntity shopCustomerEntity = shopCustomerRepository.findByOpenid(openid);
        if (shopCustomerEntity == null) {
            ShopCustomerEntity customerEntity = new ShopCustomerEntity();
            //初始化积分为零
            customerEntity.setPoint(0);
            customerEntity.setId(Identities.uuid2());
            customerEntity.setOpenid(openid);
            customerEntity.setHeadImage(wxMpUser.getHeadImgUrl());
            customerEntity.setUsername(wxMpUser.getNickname());
            customerEntity.setPayPassword("123456");
            customerEntity.setSex(wxMpUser.getSex());
            customerEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));

            shopCustomerEntity = shopCustomerService.save(customerEntity);
        }

        httpSession.setAttribute("openid", openid);

        // 把 token 和 openid 放入 Cookie 中
        TokenAuthenticationService.addToken2Cookie(request, response, openid);

        if (StringUtils.isEmpty(shopCustomerEntity.getPhone())) {
            //返回 注册手机号
            String regUrl = indexUrl.replace("index", "reg");
            return "redirect:" + regUrl + "?" + "openid=" + openid;
        }

        String token = response.getHeader(TokenAuthenticationService.HEADER_STRING);

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("openid", openid);

        indexUrl = indexUrl + "?" + "openid=" + openid + "&token=" + token;

        // 返回登陆成功信息
        return "redirect:" + indexUrl;
    }


}
