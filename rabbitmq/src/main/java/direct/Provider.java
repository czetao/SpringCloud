package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author czetao
 * @ClassName Provider.java
 * @Description 订阅模式 --- 广播模式上增加路由key转发
 * @createTime 2020年08月02日
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        // 定义交换机为direct类型
        channel.exchangeDeclare("log_direct","direct");
        String routingKey = "error";
        channel.basicPublish("log_direct",routingKey,null,("这是订阅模式，routingkey是："+routingKey).getBytes());
        RabbitMQUtils.closeConnection(channel,connection);

    }

}
