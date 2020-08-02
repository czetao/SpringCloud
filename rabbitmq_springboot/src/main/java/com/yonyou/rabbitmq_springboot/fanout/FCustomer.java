package com.yonyou.rabbitmq_springboot.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author czetao
 * @ClassName Customer.java
 * @Description 广播模式消费者
 * @createTime 2020年08月02日
 */
@Component
public class FCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //没有指定队列名字，则创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")  //绑定的交换机
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //没有指定队列名字，则创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")  //绑定的交换机
            )
    })
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }
}