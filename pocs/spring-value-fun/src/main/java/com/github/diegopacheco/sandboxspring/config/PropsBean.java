package com.github.diegopacheco.sandboxspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@PropertySource("classpath:/service.override.properties")
public class PropsBean {

    @Value("${service.env}")
    private String env;

    @Value("${service.port}")
    private Integer port;

    @Value("#{systemProperties['unknown'] ?: '/usr/local/bin/jdk8'}")
    private String javaHome;

    @Value("#{AnswerOfTheUniverse.get}")
    private int answerOfTheUniverse;

    @Value("#{systemProperties}")
    private Map<String, String> systemPropertiesMap;

    public String getEnv() {
        return env;
    }

    public Integer getPort() {
        return port;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public int getAnswerOfTheUniverse() {
        return answerOfTheUniverse;
    }

    public Map<String, String> getSystemPropertiesMap() {
        return systemPropertiesMap;
    }

    @Bean(name="AnswerOfTheUniverse")
    public AnswerOfTheUniverse getInternal(){
        return new AnswerOfTheUniverse();
    }

}
