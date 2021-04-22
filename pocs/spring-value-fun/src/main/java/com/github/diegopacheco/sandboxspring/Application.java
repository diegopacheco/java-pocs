package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.config.PropsBean;
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

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Spring Boot 2.0 working! ");

			PropsBean pb = ctx.getBean(PropsBean.class);
			System.out.println("ENV = " + pb.getEnv());
			System.out.println("Port="+pb.getPort());
			System.out.println("JAVA_HOME="+pb.getJavaHome());
			System.out.println("Answer="+pb.getAnswerOfTheUniverse());
			System.out.println("SystemProps="+pb.getSystemPropertiesMap());
		};
	}
}

