package com.github.diegopacheco.pocs.java.webflux;

import com.github.diegopacheco.pocs.java.webflux.client.CatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.diegopacheco.pocs.java.webflux.*")
public class WebfluxRestClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxRestClientApplication.class, args);
	}

	@Autowired
	CatClient client;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(
				"Same important Cat fat: " +
				client.getFact().block());
	}
}
