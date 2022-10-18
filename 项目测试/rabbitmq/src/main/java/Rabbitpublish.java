import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
//import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootTest
public class Rabbitpublish {
    // 基本消息模式，直接发到队列
//    @Test
    public void testSendMessage() throws IOException, TimeoutException {
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
        Channel channel = connection.createChannel();

        // 3.创建队列
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, true, false, false, null);

        // 4.发送消息
        String message = "hello, rabbitmq!==>";
        for (int i = 0; i < 50; i++) {
            channel.basicPublish("", queueName, null, (message+i).getBytes());
            System.out.println("发送消息成功：【" + message  + "】");
        }

        // 5.关闭通道和连接
        channel.close();
        connection.close();

    }
}
