package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author czetao
 * @ClassName Provider.java
 * @Description 动态路由模式 生产者
 *
 * @createTime 2020年08月02日
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "topics";

        // 定义交换机为direct类型
        channel.exchangeDeclare(exchangeName,"topic");
        String routingKey = "user.save";
        channel.basicPublish(exchangeName,routingKey,null,("这是topic动态路由模式，routingkey是："+routingKey).getBytes());
        // 关闭资源
        RabbitMQUtils.closeConnection(channel,connection);

    }


}



