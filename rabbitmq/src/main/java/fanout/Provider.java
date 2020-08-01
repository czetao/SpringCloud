package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * 广播模式 生产者
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 将通道声明指定交换机
         * 参数 1：交换机名称
         * 参数 2：交换机类型
         */
        channel.exchangeDeclare("logs","fanout") ;
        // 发送消息
        channel.basicPublish("logs","",null,"fanout message".getBytes());
        RabbitMQUtils.closeConnection(channel,connection);

    }
}
