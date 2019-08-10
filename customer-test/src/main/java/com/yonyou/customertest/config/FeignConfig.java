package com.yonyou.customertest.config;

import com.yonyou.customertest.feign.UserFeignClient;
import model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/10 15:40
 * @Description: 无法注入bean，通过添加配置，注入bean
 */
@Configuration
public class FeignConfig {

    /***
     * 手动将bean注入到spring容器中
     * @return
     */
    @Bean
    public UserFeignClient userFeignClient(){
        return new UserFeignClient() {
            @Override
            public Boolean login(User user) {
                return null;
            }
        };
    }
}
