import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MainProducer {
  public static void main(String args[]) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    factory.setPort(5672);
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.queueDeclare("products_queue", false, false, false, null);
    String message = "product details";
    channel.basicPublish("", "products_queue", null, message.getBytes());
    channel.close();
    connection.close();
    System.out.println("Message sent - all good.");
  }
}
