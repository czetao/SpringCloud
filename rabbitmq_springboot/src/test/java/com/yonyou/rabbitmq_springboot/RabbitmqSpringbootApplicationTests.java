package com.yonyou.rabbitmq_springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
// 启动spring工厂
@RunWith(SpringRunner.class)
class RabbitmqSpringbootApplicationTests {

    // 注入
    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * helloworld
     */
    @Test
    void helloworld() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    /**
     * work 工作队列
     */
    @Test
    void workQueue() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work"+i);
        }
    }

    /**
     * fanout 广播
     */
    @Test
    void testFanout() {
        rabbitTemplate.convertAndSend("logs","","Fanout的模型发送的消息");
    }

    /**
     * routing 路由
     */
    @Test
    void testRouting() {
        rabbitTemplate.convertAndSend("directs","error","发送info");
    }

    /**
     * topics 订阅模式routing 路由 多了*#
     */
    @Test
    void testTopics() {
        rabbitTemplate.convertAndSend("topics","user.save.sta","user.save路由消息");
    }

}
