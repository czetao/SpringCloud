package com.yonyou.rabbitmq_springboot.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author czetao
 * @ClassName Rcustomer.java
 * @Description 路由模型
 * @createTime 2020年08月02日
 */
@Component
public class Rcustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //没有指定队列名字，则创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct") , //绑定的交换机
                    key = {"info","error","warn"}  // 定义指定的路由key
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //没有指定队列名字，则创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct") , //绑定的交换机
                    key = {"error"}  // 定义指定的路由key
            )
    })
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }
}
