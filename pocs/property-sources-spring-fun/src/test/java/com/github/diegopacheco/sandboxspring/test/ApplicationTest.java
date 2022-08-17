package com.github.diegopacheco.sandboxspring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import(ApplicationTest.Config.class)
public class ApplicationTest {

    @Value("${x}") private String valueOfX;
    @Value("${y}") private String valueOfY;
    @Value("${host}") private String host;
    @Value("${appname}") private String app;

    @Configuration
    @PropertySources({
            @PropertySource("classpath:config.properties"),
            @PropertySource("classpath:db.properties"),
    })
    public static class Config {
        @Bean
        public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            PropertySourcesPlaceholderConfigurer properties =
                    new PropertySourcesPlaceholderConfigurer();
            properties.setLocation(new FileSystemResource(
                    new File(".").getAbsolutePath()+
                    "/app.properties"));
            properties.setIgnoreResourceNotFound(false);
            return properties;
        }
    }

    @Test
    public void testProps(){
        System.out.println("x: " + valueOfX);
        System.out.println("y: " + valueOfY);
        System.out.println("host: " + host);
        System.out.println("app: " + app);

        assertEquals("10",valueOfX);
        assertEquals("20",valueOfY);
        assertEquals("3309",host);
        assertEquals("App",app);
    }

}
