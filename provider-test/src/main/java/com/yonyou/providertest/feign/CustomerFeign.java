package com.yonyou.providertest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/8 15:09
 * @Description: 标识这是一个feignClient 并服务提供方的api接口以接口形式外放
 */

@FeignClient(name = "customer-demo")
public interface CustomerFeign {
    @GetMapping("/test")
    String test();

}
