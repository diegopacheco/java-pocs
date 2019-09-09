package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaSpringApp implements CommandLineRunner {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public SpringKafkaSpringApp(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @KafkaListener(topics = "myTopic")
  public void processMessage(String content) {
    System.out.println(content);
  }

  @Override
  public void run(String... args) {
    System.out.println("Spring app Running... " + kafkaTemplate);
    kafkaTemplate.send("myTopic", "hey how is it going? ");
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaSpringApp.class, args);
  }

}