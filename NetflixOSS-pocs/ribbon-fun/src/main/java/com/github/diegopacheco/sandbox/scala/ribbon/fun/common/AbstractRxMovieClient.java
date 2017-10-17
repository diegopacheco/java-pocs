package com.github.diegopacheco.sandbox.scala.ribbon.fun.common;

import static java.lang.String.format;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

import com.netflix.hystrix.util.HystrixTimer;

public abstract class AbstractRxMovieClient {
    protected static final String TEST_USER = "user1";
    protected static final Pattern NEW_LINE_SPLIT_RE = Pattern.compile("\n");

    protected abstract Observable<ByteBuf>[] triggerMoviesRegistration();

    protected abstract Observable<ByteBuf>[] triggerRecommendationsUpdate();

    protected abstract Observable<ByteBuf>[] triggerRecommendationsSearch();

    protected Observable<ByteBuf> registerMovies() {
        return Observable.concat(Observable.from(triggerMoviesRegistration()));
    }

    protected Observable<ByteBuf> updateRecommendations() {
        return Observable.concat(Observable.from(triggerRecommendationsUpdate()));
    }

    protected Observable<Void> searchCatalog() {
        List<String> searches = new ArrayList<String>(2);
        Collections.addAll(searches, "findById", "findRawMovieById", "findMovie(name, category)");

        return Observable.concat(Observable.from(triggerRecommendationsSearch())).flatMap(new Func1<ByteBuf, Observable<List<Movie>>>() {
            public Observable<List<Movie>> call(ByteBuf byteBuf) {
                List<Movie> movies = new ArrayList<Movie>();
                String lines = byteBuf.toString(Charset.defaultCharset());
                for (String line : NEW_LINE_SPLIT_RE.split(lines)) {
                    movies.add(Movie.from(line));
                }
                return Observable.just(movies);
            }
        }).zip(searches, new Func2<List<Movie>, String, Void>() {
            public Void call(List<Movie> movies, String query) {
                System.out.println(format("    %s=%s", query, movies));
                return null;
            }
        });
    }

    public boolean runExample() {
        boolean allGood = true;
        try {
            System.out.print("Registering movies...");

            Notification<Void> result = executeServerCalls();
            allGood = !result.isOnError();
            if (allGood) {
                System.out.println("Application finished");
            } else {
                System.err.println("ERROR: execution failure");
                result.getThrowable().printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            allGood = false;
        } finally {
            shutdown();
        }
        return allGood;
    }

    Notification<Void> executeServerCalls() {
        Observable<Void> resultObservable = registerMovies().materialize().flatMap(
                new Func1<Notification<ByteBuf>, Observable<Void>>() {
                    public Observable<Void> call(Notification<ByteBuf> notif) {
                        if (!verifyStatus(notif)) {
                            return Observable.error(notif.getThrowable());
                        }
                        System.out.print("Updating user recommendations...");
                        return updateRecommendations().materialize().flatMap(
                                new Func1<Notification<ByteBuf>, Observable<Void>>() {
                                    public Observable<Void> call(Notification<ByteBuf> notif) {
                                        if (!verifyStatus(notif)) {
                                            return Observable.error(notif.getThrowable());
                                        }
                                        System.out.println("Searching through the movie catalog...");
                                        return searchCatalog();
                                    }
                                });
                    }
                }
        );
        return resultObservable.materialize().toBlocking().last();
    }

    protected void shutdown() {
        HystrixTimer.reset();
    }

    private static boolean verifyStatus(Notification<ByteBuf> notif) {
        if (notif.isOnError()) {
            System.out.println("ERROR");
            return false;
        }
        System.out.println("DONE");
        return true;
    }
}