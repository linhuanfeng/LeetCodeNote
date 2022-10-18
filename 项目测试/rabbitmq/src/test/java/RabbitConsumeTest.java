import com.rabbitmq.client.*;
//import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Deprecated // 不能够正常接受消息，且线程直接结束
@SpringBootTest
public class RabbitConsumeTest {
    // 基本消息模式，直接发到队列
//    @Test
    public void testConsumerBasic() throws IOException, TimeoutException {
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

        // 4.订阅消息
        channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
            // 存储consumerTag
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //                // 5.处理消息
                String message = new String(body);
//                channel.basicAck(envelope.getDeliveryTag(),false);
                System.out.println("接收到消息：【" + message + "】");
            }
        });
        System.out.println("等待接收消息。。。。");
    }
}
