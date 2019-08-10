package com.yonyou.customertest.controller;

import com.yonyou.customertest.feign.UserFeignClient;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/10 15:32
 * @Description: 调用模块
 */

@RestController
public class LoginController {


    /***
     * 注入feign接口。
     */
    @Autowired
    private UserFeignClient userFeignClient;

    /***
     * 通过feign调用另外一个服务的接口
     * @param user
     * @return
     */
    @RequestMapping("/userlogin")
    public String login(User user){
        if (userFeignClient.login(user)){
            return "hello,"+user.getUsername();
        }else {
            return "fail,"+user.getUsername();
        }

    }
}
