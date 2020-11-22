import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.github.diegopacheco.sandboxspring")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

