import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FluxTest {

    @Test
    public void testSubscribe() {
       Flux<String> paused = Flux.just("Hello")
                .concatWith(Flux.just("world")
                .delaySubscription(Duration.ofMillis(500)));

       paused.toStream().forEach( r-> {
           System.out.println(r);
           assertNotNull(r);
       });
    }

    @Test
    public void firstEmitting() {
        Mono<String> a = Mono.just("oops I'm late")
                .delaySubscription(Duration.ofMillis(450));

        Flux<String> b = Flux.just("let's get", "the party", "started")
                .delaySubscription(Duration.ofMillis(400));

        Flux.firstWithSignal(a, b)
                .toIterable()
                .forEach(System.out::println);
    }


}
