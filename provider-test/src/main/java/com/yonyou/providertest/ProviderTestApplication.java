package com.yonyou.providertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableDiscoveryClient和@EnableEurekaClient
// 共同点就是：都是能够让注册中心能够发现，扫描到该服务。
//不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心，比如Zookeeper
@EnableEurekaClient
@SpringBootApplication
public class ProviderTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTestApplication.class, args);
    }

}
 