package com.github.diegopacheco.sandboxspring.client.test;

import com.github.diegopacheco.sandboxspring.Application;
import com.github.diegopacheco.sandboxspring.dao.ThingDao;
import com.github.diegopacheco.sandboxspring.model.Thing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= Application.class)
public class ReactiveClientTest {

    @LocalServerPort
    private int port;

    @Test
    public void testReactiveCall(){
        WebClient webClient = WebClient.create("http://localhost:" + port);
        Mono<Thing> thingMono = webClient.get()
                .uri("/mono/")
                .retrieve()
                .bodyToMono(Thing.class);
        thingMono.subscribe(System.out::println);
        Thing t = thingMono.block();
        System.out.println("This is what I got back as well: " + t);
        Assertions.assertNotNull(t);
    }

}


