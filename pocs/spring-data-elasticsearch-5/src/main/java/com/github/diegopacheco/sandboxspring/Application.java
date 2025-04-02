package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.model.Product;
import com.github.diegopacheco.sandboxspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.github.diegopacheco.sandboxspring")
public class Application {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Spring Boot 3.4.x working!");
	}

	@Bean
	public CommandLineRunner demo() {
		return args -> {
			Product product1 = new Product("1", "Laptop", "High-performance laptop", 1299.99);
			Product product2 = new Product("2", "Smartphone", "Latest model smartphone", 899.99);
			productService.save(product1);
			productService.save(product2);

			System.out.println("Sample products saved to Elasticsearch");
		};
	}
}