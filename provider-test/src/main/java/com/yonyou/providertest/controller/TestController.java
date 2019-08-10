package com.yonyou.providertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/8 13:51
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/indexs")
    public String test(){
        return "测试配置。";
    }

    /***
     * 调用customer
     * @return
     */
    @RequestMapping("/callCustomer")
    public String callProvider(){
        String url = "http://customer-demo/test";
        String response = restTemplate.getForObject(url,String.class);
        return response;
    }


}
