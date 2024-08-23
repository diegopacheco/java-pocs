package com.github.diegopacheco.sandboxspring.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class CatFactsDriver {

    @Autowired
    private HttpClient client;

    public String getFact(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://catfact.ninja/fact"))
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .GET()
                .build();
        try{
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
