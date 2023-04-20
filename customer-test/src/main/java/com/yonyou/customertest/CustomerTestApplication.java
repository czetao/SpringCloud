package com.yonyou.customertest;

import com.yonyou.customertest.feign.UserFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Eureka客户端
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
//Feign客户端,通过此注解开启feign客户端
// clients 指明feignclients
@EnableFeignClients
public class CustomerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTestApplication.class, args);
    }

}
