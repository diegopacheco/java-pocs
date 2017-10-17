package com.github.diegopacheco.sandbox.scala.ribbon.fun;

import static java.lang.String.format;
import io.netty.buffer.ByteBuf;
import io.reactivex.netty.channel.StringTransformer;
import io.reactivex.netty.protocol.http.client.HttpClientRequest;
import io.reactivex.netty.protocol.http.client.HttpClientResponse;
import rx.Observable;
import rx.functions.Func1;

import com.github.diegopacheco.sandbox.scala.ribbon.fun.common.AbstractRxMovieClient;
import com.github.diegopacheco.sandbox.scala.ribbon.fun.common.Movie;
import com.github.diegopacheco.sandbox.scala.ribbon.fun.common.RxMovieServer;
import com.github.diegopacheco.sandbox.scala.ribbon.fun.common.RxMovieTransformer;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.IClientConfig;
import com.netflix.ribbon.transport.netty.RibbonTransport;
import com.netflix.ribbon.transport.netty.http.LoadBalancingHttpClient;

public class RxMovieTransportExample extends AbstractRxMovieClient {

    private final LoadBalancingHttpClient<ByteBuf, ByteBuf> client;

    public RxMovieTransportExample(int port) {
        IClientConfig clientConfig = IClientConfig.Builder.newBuilder("movieServiceClient").build();
        clientConfig.set(CommonClientConfigKey.ListOfServers, "127.0.0.1:" + port);
        client = RibbonTransport.newHttpClient(clientConfig);
    }

    protected Observable<ByteBuf>[] triggerMoviesRegistration() {
        return new Observable[]{
                registerMovie(Movie.ORANGE_IS_THE_NEW_BLACK),
                registerMovie(Movie.BREAKING_BAD),
                registerMovie(Movie.HOUSE_OF_CARDS)
        };
    }

    private Observable<Void> registerMovie(Movie movie) {
        HttpClientRequest<ByteBuf> httpRequest = HttpClientRequest.createPost("/movies")
                .withHeader("X-Platform-Version", "xyz")
                .withHeader("X-Auth-Token", "abc")
                .withRawContentSource(Observable.just(movie), new RxMovieTransformer());

        return client.submit(httpRequest).flatMap(new Func1<HttpClientResponse<ByteBuf>, Observable<Void>>() {
            public Observable<Void> call(HttpClientResponse<ByteBuf> httpClientResponse) {
                if (httpClientResponse.getStatus().code() / 100 != 2) {
                    return Observable.error(new RuntimeException(
                            format("HTTP request failed (status code=%s)", httpClientResponse.getStatus())));
                }
                return Observable.empty();
            }
        });
    }

    protected Observable<ByteBuf>[] triggerRecommendationsUpdate() {
        return new Observable[]{
                updateRecommendation(TEST_USER, Movie.ORANGE_IS_THE_NEW_BLACK),
                updateRecommendation(TEST_USER, Movie.BREAKING_BAD)
        };
    }

    private Observable<Void> updateRecommendation(String user, Movie movie) {
        HttpClientRequest<ByteBuf> httpRequest = HttpClientRequest.createPost(format("/users/%s/recommendations", user))
                .withHeader("X-Platform-Version", "xyz")
                .withHeader("X-Auth-Token", "abc")
                .withRawContentSource(Observable.just(movie.getId()), new StringTransformer());

        return client.submit(httpRequest).flatMap(new Func1<HttpClientResponse<ByteBuf>, Observable<Void>>() {
            public Observable<Void> call(HttpClientResponse<ByteBuf> httpClientResponse) {
                if (httpClientResponse.getStatus().code() / 100 != 2) {
                    return Observable.error(new RuntimeException(
                            format("HTTP request failed (status code=%s)", httpClientResponse.getStatus())));
                }
                return Observable.empty();
            }
        });
    }

    protected Observable<ByteBuf>[] triggerRecommendationsSearch() {
        HttpClientRequest<ByteBuf> httpRequest = HttpClientRequest.createGet(format("/users/%s/recommendations", TEST_USER))
                .withHeader("X-Platform-Version", "xyz")
                .withHeader("X-Auth-Token", "abc");
        Observable<ByteBuf> searchByUserObservable = client.submit(httpRequest).flatMap(new Func1<HttpClientResponse<ByteBuf>, Observable<ByteBuf>>() {
            public Observable<ByteBuf> call(HttpClientResponse<ByteBuf> httpClientResponse) {
                if (httpClientResponse.getStatus().code() / 100 != 2) {
                    return Observable.error(new RuntimeException(
                            format("HTTP request failed (status code=%s)", httpClientResponse.getStatus())));
                }
                return httpClientResponse.getContent();
            }
        });

        httpRequest = HttpClientRequest.createGet("/recommendations?category=Drama&ageGroup=Adults")
                .withHeader("X-Platform-Version", "xyz")
                .withHeader("X-Auth-Token", "abc");
        Observable<ByteBuf> searchByCriteriaObservable = client.submit(httpRequest).flatMap(new Func1<HttpClientResponse<ByteBuf>, Observable<ByteBuf>>() {
            public Observable<ByteBuf> call(HttpClientResponse<ByteBuf> httpClientResponse) {
                if (httpClientResponse.getStatus().code() / 100 != 2) {
                    return Observable.error(new RuntimeException(
                            format("HTTP request failed (status code=%s)", httpClientResponse.getStatus())));
                }
                return httpClientResponse.getContent();
            }
        });

        return new Observable[]{searchByUserObservable, searchByCriteriaObservable};
    }

    public static void main(String[] args) {
        System.out.println("Starting transport based movie service...");
        new RxMovieTransportExample(RxMovieServer.DEFAULT_PORT).runExample();
    }
}