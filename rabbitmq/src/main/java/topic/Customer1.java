package topic;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author czetao
 * @ClassName Customer1.java
 * @Description 动态路由 消费者1
 * @createTime 2020年08月02日
 */
public class Customer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "topics";

        // 定义交换机为direct类型
        channel.exchangeDeclare(exchangeName,"topic");
        // 创建临时队列
        String queue = channel.queueDeclare().getQueue();
        // 给予routingkey 绑定交换机 和 队列
        channel.queueBind(queue,exchangeName,"user.*");
        // 接收消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1：" + new String(body));
            }
        });
    }
}
