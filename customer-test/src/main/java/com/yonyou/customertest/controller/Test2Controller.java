package com.yonyou.customertest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/8 14:47
 * @Description:
 */
@RestController
public class Test2Controller {


    @RequestMapping("/test")
    public String test(){
        System.out.println("receive a provider message");
        return "customer";
    }



}
