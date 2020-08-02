package com.yonyou.rabbitmq_springboot.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author czetao
 * @ClassName Cystomer.java
 * @Description 工作模式 消费者
 * @createTime 2020年08月02日
 */
@Component
public class Customer {

    /**
     * 第一个消费者
     * @param message
     */
    @RabbitListener(queuesToDeclare = @Queue("work"))
    private void receive(String message){
        System.out.println("消费者1" + message);
    }

    /**
     * 第二个消费者
     * @param message
     */
    @RabbitListener(queuesToDeclare = @Queue("work"))
    private void receive2(String message){
        System.out.println("消费者2" + message);
    }
}
