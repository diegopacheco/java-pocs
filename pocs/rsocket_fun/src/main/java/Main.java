import java.time.Duration;

import org.reactivestreams.Publisher;

import io.rsocket.AbstractRSocket;
import io.rsocket.ConnectionSetupPayload;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.SocketAcceptor;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.local.LocalClientTransport;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.ByteBufPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Main {

  static final Payload payload1 = ByteBufPayload.create("Hello ");

  public static void main(String args[]){
    RSocketFactory.receive()
        .frameDecoder(PayloadDecoder.ZERO_COPY)
        .acceptor(new SocketAcceptorImpl())
        .transport(TcpServerTransport.create(7878))
        .start()
        .block()
        .onClose()
        .block();

    RSocket socket =
    RSocketFactory.connect()
        .keepAliveAckTimeout(Duration.ofMinutes(10))
        .frameDecoder(PayloadDecoder.ZERO_COPY)
        .transport(LocalClientTransport.create("localhost"))
        .start()
        .block();

    Flux.range(0, 100)
    .concatMap(i -> socket.fireAndForget(payload1.retain()))
            .doOnNext(p -> {
                System.out.println(p.toString());
            })
    .blockLast();
  }

  private static class SocketAcceptorImpl implements SocketAcceptor {
    @Override
    public Mono<RSocket> accept(ConnectionSetupPayload setupPayload, RSocket reactiveSocket) {
      return Mono.just(
          new AbstractRSocket() {

            @Override
            public Mono<Void> fireAndForget(Payload payload) {
              payload.release();
              return Mono.empty();
            }

            @Override
            public Mono<Payload> requestResponse(Payload payload) {
              return Mono.just(payload);
            }

            @Override
            public Flux<Payload> requestChannel(Publisher<Payload> payloads) {
              return Flux.from(payloads).subscribeOn(Schedulers.single());
            }
          });
    }
  }
  
}
