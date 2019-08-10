package com.yonyou.customertest.feign;

import com.yonyou.customertest.feign.impl.UserFeignclientFallback;
import model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/10 15:29
 * @Description: 通过feign，通过服务中心寻找provider-demo服务，并调用其中的具体接口，返回值等要一致
 */
//fallback服务出错时，调用的备胎逻辑，当服务宕机时，跳转到此列中，不会报服务异常。
@FeignClient(name = "provider-demo",fallback = UserFeignclientFallback.class)
public interface UserFeignClient {

    /***
     * 方法的参数，http方法，返回值等都应该与另外一个服务中的方法一致
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(@RequestBody User user);
}
