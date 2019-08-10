package com.yonyou.providertest.controller;

import model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/10 14:59
 * @Description:
 */

@RestController
public class UserService {

    /***
     * 通过引入公共模块中的JavaBean，进行参数的传递
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(@RequestBody User user) {

        return "admin".equals(user.getUsername()) && "12345".equals(user.getPassword());
    }

    //
}
