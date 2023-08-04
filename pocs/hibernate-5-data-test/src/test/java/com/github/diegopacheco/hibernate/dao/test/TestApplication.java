package com.github.diegopacheco.hibernate.dao.test;

import com.github.diegopacheco.hibernate.dao.ContactRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Really necessary or you will get:
// Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...)
@SpringBootApplication(scanBasePackages = "com.github.diegopacheco.hibernate.dao.*")
public class TestApplication {}