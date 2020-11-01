import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Date;

public class MainProducer {
  public static void main(String args[]) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    factory.setPort(5672);
    factory.setUsername("guest");
    factory.setPassword("guest");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.queueDeclare("", false, false, false, null);
    String message = "product details " + new Date();
    channel.basicPublish("", "products_queue", null, message.getBytes());

    Thread.sleep(2000L);

    channel.close();
    connection.close();
    System.out.println("Message sent - all good.");
  }
}
