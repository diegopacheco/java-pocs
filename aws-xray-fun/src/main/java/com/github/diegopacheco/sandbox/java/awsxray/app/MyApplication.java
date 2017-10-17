package com.github.diegopacheco.sandbox.java.awsxray.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.github.diegopacheco.sandbox.java.awsxray.rest.CalcController;

@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CalcController.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CalcController.class, args);
    }
	
}
