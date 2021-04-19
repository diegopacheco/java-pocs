package com.github.diegopacheco.mockserver.tests.bizcode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CartManager {

    public void viewCart(){
        try{
            get("http://127.0.0.1:8081/view/cart?cartId=055CA455-1DF7-45BB-8535-4F83E7266092");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
