import com.github.diegopacheco.hibernate.dao.DBFeeder;
import com.github.diegopacheco.hibernate.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.diegopacheco")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Autowired
    DBFeeder feeder;

    @Autowired
    ContactService service;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println(">>> Spring Boot 2.7.13, Hibernate 5.6.15 up and running! ");

            System.out.println("Feeding 10 records to the DB via Hibernate... ");
            feeder.feedData();
            System.out.println("DONE. ");

            System.out.println("All Records: ");
            service.list().forEach(System.out::println);
            System.out.println("DONE. ");
        };
    }

    @Bean
    public CommandLineRunner benchmark(ApplicationContext ctx) {
        System.out.println("Running Benchmarks... ");
        return args -> {
            System.out.println("Benchmark 10 in: " + feeder.benchmark(10) + " ms");
            System.out.println("Benchmark 100 in: " + feeder.benchmark(100) + " ms");
            System.out.println("Benchmark 1k in: " + feeder.benchmark(1000) + " ms");
            System.out.println("Benchmark 10k in: " + feeder.benchmark(10000) + " ms");
        };
    }
}