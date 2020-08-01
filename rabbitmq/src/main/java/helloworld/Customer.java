package helloworld;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    // 使用测试类无法模拟消费者，会自动停到
    @Test
    public void getMessage() throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();

        // 获取连接中通道
        Channel channel = connection.createChannel();

        // 通道绑定对应消息队列
        /***
         * 参数1 ：队列名称 如果队列不存在自动创建
         * 参数2 ：用来定义队列特性是否要持久化 true 持久化队列， false 不持久化
         * 参数3 ：exclusive 是否独占队列，true 独占队列 false 不独占队列
         * 参数4 ：autodelete :是否在消费完成之后自动删除队列 true 自动删除 false 不自动删除
         * 参数5 ：额外附加参数
         */
        channel.queueDeclare("hello",false,false,false,null);
        /**
         * 消费消息
         * 参数1：队列名称
         * 参数2：autoAck 开始消息的自动确认机制
         * 参数3：消费时的回调接口
         */
        channel.basicConsume("hello",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body =" + new String(body));
            }
        });

        /*channel.close();
        connection.close();*/
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接rabbitmq主机
        connectionFactory.setHost("192.168.31.216");
        // 设置端口号
        connectionFactory.setPort(5672);
        // 设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();

        // 获取连接中通道
        Channel channel = connection.createChannel();

        // 通道绑定对应消息队列
        /***
         * 参数1 ：队列名称 如果队列不存在自动创建
         * 参数2 ：用来定义队列特性是否要持久化 true 持久化队列， false 不持久化
         * 参数3 ：exclusive 是否独占队列，true 独占队列 false 不独占队列
         * 参数4 ：autodelete :是否在消费完成之后自动删除队列 true 自动删除 false 不自动删除
         * 参数5 ：额外附加参数
         */
        channel.queueDeclare("hello",true,false,false,null);
        /**
         * 消费消息
         * 参数1：队列名称
         * 参数2：autoAck 开始消息的自动确认机制  消费者自动向rabbitmq确认消息消费  false 不会自动确认消息
         * 参数3：消费时的回调接口
         */
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body ===========" + new String(body));
            }
        });

        /*channel.close();
        connection.close();*/
    }
}
