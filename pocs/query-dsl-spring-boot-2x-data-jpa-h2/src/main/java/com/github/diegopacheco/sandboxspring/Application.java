package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.model.Book;
import com.github.diegopacheco.sandboxspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.github.diegopacheco.sandboxspring")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	BookService service;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Cleaning up all previous books");
			service.deleteAllBooks();

			Book b = new Book();
			b.setAuthor("Diego Pacheco");
			b.setId(1L);
			b.setTitle("Building Applications with Scala");
			service.save(b);

			System.out.println("Done. Checkout: http://localhost:8080/h2-console/");
		};
	}
}

