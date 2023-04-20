package com.yonyou.rabbitmq_springboot.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author czetao
 * @ClassName Tcustomer.java
 * @Description 发布订阅 topicExchange
 * 与DirectExchange类似，区别在于routingkey 必须是多个单词的列表，并且以 . 分割
 * 1. # 指的是0个或多个单词
 * 2. * 代指一个单词
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
