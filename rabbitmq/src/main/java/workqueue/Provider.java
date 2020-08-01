package workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {

        // 获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("work",true,false,false,null);
        for (int i = 0;i<20;i++){
             channel.basicPublish("","work",null,(i+"hello workqueue").getBytes());
        }
        RabbitMQUtils.closeConnection(channel,connection);
    }
}
