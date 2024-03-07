package com.github.diegopacheco.reactor.poc.ctx;

import com.github.diegopacheco.reactor.poc.ctx.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.diegopacheco.reactor.poc.ctx")
public class FluxMonoCtxApplication implements CommandLineRunner {

	@Autowired
	private LogService log;

	public static void main(String[] args) {
		SpringApplication.run(FluxMonoCtxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.log("hello world spring webflux");
	}
}
