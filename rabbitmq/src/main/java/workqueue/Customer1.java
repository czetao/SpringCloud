package workqueue;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Customer1 {


    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("work",true,false,false,null);

        // 每一次只能消费一个消息
        channel.basicQos(1);
        /***
         * 参数2：autoAck 开始消息的自动确认机制  消费者自动向rabbitmq确认消息消费  false 不会自动确认消息
         */
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者 ==== 1 ========" +new String(body));
                // 手动确认 参数1：手动确认消息标识  参数2：false 是否开启多个消息同时确认
                // 确认消息之后，队列才会将这条消息删除
                // 通过这种手动确认消息，能够保证消息永不消失
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
