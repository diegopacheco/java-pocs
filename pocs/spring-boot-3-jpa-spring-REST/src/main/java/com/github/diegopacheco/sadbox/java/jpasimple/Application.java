package com.github.diegopacheco.sadbox.java.jpasimple;

import com.github.diegopacheco.sadbox.java.jpasimple.dao.ContactRepository;
import com.github.diegopacheco.sadbox.java.jpasimple.model.Contact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.LongStream;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.github.diegopacheco.sadbox.java.jpasimple"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Contact c = new Contact();
						c.setName("Contact " + i);
						c.setEmail("contact" + i + "@email.com");
						c.setPhone("(111) 111-1111");
						return c;
					})
					.map(repository::save)
					.forEach(System.out::println);
		};
	}

}
