package com.github.diegopacheco.hibernate.dao.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Really necessary or you will get:
// Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...)
@SpringBootApplication(
        scanBasePackages={"com.github.diegopacheco.hibernate.dao.*","com.github.diegopacheco.hibernate.service.*"})
@TestConfiguration
@EnableJpaAuditing
public class TestApplication {}
