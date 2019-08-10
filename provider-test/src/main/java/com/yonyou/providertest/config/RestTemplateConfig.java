package com.yonyou.providertest.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/8 14:14
 * @Description: 通过配置，将属性注入到spring容器中
 */

@Configuration
public class RestTemplateConfig {

    // 为RestTemplateConfig添加负载均衡的能力
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
