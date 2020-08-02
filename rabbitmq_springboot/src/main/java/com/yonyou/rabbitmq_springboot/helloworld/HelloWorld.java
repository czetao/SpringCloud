package com.yonyou.rabbitmq_springboot.helloworld;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author czetao
 * @ClassName HelloWorld.java
 * @Description 点对点消费者
 * @createTime 2020年08月02日
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloWorld {

    // 回调方法
    @RabbitHandler
    private void receive(String message){
        System.out.println("message = " + message);
    }
}
