package com.yonyou.customertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Eureka客户端
@EnableEurekaClient
@SpringBootApplication
//Feign客户端
@EnableFeignClients
public class CustomerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTestApplication.class, args);
    }

}
