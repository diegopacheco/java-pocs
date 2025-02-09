package com.github.diegopacheco.sandboxspring.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
public class GsonConfig {

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
        gsonConverter.setGson(gson);
        return gsonConverter;
    }
}