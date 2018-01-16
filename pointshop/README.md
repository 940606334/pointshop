# 积分商城重构版


* 使用 Swagger2 构建 API文档,文档地址: http://localhost/swagger-ui.html 

> 测试时注意:因为添加了安全校验,在微信网页授权成功之后,服务端会在响应头中放一个token和在cookie中设置一个token
  以后所有的请求都要在cookie或者请求头中(二者至少选一个)带上这个 token ,否则服务器会返回响应码 403,禁止访问.
  可以在 postman 中方便的进行测试.

* 使用 mysql 多数据源(Spring Data Jpa),涉及两个数据库.

* 增加安全认证,使用jwt和Spring Security(注意和Swagger整合时静态页面的拦截问题)
> 还要注意: 由于登陆使用了微信的网页授权,所以 Spring Security 的登陆就去掉了.

* 使用 SpringBoot 自带的定时任务(或者 quarze )进行crm各店铺的数据同步.