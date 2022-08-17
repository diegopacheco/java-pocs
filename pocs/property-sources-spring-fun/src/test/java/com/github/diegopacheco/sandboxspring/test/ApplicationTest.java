package com.github.diegopacheco.sandboxspring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import(ApplicationTest.Config.class)
public class ApplicationTest {

    @Value("${x}") private String valueOfX;
    @Value("${y}") private String valueOfY;
    @Value("${host}") private String host;

    @Configuration
    @PropertySources({
            @PropertySource("classpath:config.properties"),
            @PropertySource("classpath:db.properties")
    })
    public static class Config {}

    @Test
    public void testProps(){
        System.out.println("x: " + valueOfX);
        System.out.println("y: " + valueOfY);
        System.out.println("host: " + host);

        assertEquals("10",valueOfX);
        assertEquals("20",valueOfY);
        assertEquals("3309",host);
    }

}
