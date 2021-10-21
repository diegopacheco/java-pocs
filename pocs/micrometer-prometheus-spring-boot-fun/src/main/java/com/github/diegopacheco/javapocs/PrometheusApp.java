package com.github.diegopacheco.javapocs;

import com.github.diegopacheco.javapocs.controller.PersonController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackageClasses = PersonController.class)
@EnableScheduling
@ComponentScan("com.github.diegopacheco.javapocs")
public class PrometheusApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PrometheusApp.class).profiles("prometheus").run(args);
    }
}