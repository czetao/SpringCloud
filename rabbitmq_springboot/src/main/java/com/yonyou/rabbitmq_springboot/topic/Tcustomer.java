package com.yonyou.rabbitmq_springboot.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author czetao
 * @ClassName Tcustomer.java
 * @Description TODO
 * @createTime 2020年08月02日
 */
@Component
public class Tcustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //没有指定队列名字，则创建临时队列
                    exchange = @Exchange(value = "topics",type = "topic") , //绑定的交换机名字，绑定的交换机
                    key = {"user.*"}  // 定义指定的路由key
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //没有指定队列名字，则创建临时队列
                    exchange = @Exchange(value = "topics",type = "topic") , //绑定的交换机名字，绑定的交换机
                    key = {"user.#"}  // 定义指定的路由key
            )
    })
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }
}
