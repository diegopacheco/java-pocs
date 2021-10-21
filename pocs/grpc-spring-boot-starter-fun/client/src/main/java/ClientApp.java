import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.diegopacheco.javapocs")
public class ClientApp {
  public static void main(String[] args) {
    SpringApplication.run(ClientApp.class, args);
  }
}
