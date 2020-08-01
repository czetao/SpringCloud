package fanout;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * 广播模式 消费者
 * 广播模式暂时不需要用到 路由key
 */
public class Customer3 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs","fanout");
        // 构建临时队列
        String queue = channel.queueDeclare().getQueue();
        // 绑定交换机 和 队列
        channel.queueBind(queue,"logs","");

        // 消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者3" + new String(body));
            }
        });

    }
}
