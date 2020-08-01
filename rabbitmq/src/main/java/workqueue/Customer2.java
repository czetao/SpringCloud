package workqueue;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Customer2 {


    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("work",true,false,false,null);

        channel.basicQos(1);
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者 =====2  ========" +new String(body));
                // 手动确认 参数1：手动确认消息标识  参数2：false 是否开启多个消息同时确认
                // 确认消息之后，队列才会将这条消息删除
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
