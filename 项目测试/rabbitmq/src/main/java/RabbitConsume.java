import com.rabbitmq.client.*;
//import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConsume {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("192.168.42.100");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123");
        // 1.2.建立连接
        Connection connection = factory.newConnection();

        // 2.创建通道Channel
        final Channel channel = connection.createChannel();

        // 3.创建队列
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, true, false, false, null);
        channel.basicQos(1); // 一次只能请求1条，处理完才能吓一条，能者多劳，量力而为
        // 4.订阅消息
        channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                int i=1/0; // 业务异常，手动ack保证消息不丢失
                // 5.处理消息
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String message = new String(body);
                channel.basicAck(envelope.getDeliveryTag(),false);
                System.out.println("消费者二接收到消息：【" + message + "】");
            }
        });
        System.out.println("等待接收消息。。。。");
    }
}
