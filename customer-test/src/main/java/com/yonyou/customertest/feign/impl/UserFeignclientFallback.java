package com.yonyou.customertest.feign.impl;

import com.yonyou.customertest.feign.UserFeignClient;
import model.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/10 17:55
 * @Description: 容错机制，当服务挂掉时，跳转到这个类。
 */

@Component
public class UserFeignclientFallback implements UserFeignClient {
    /***
     * 通过继承feign接口，定义当服务宕机时，熔断处理的业务逻辑
     * @param user
     * @return
     */
    @Override
    public Boolean login(User user) {
        return false;
    }
}
