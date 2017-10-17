package com.github.diegopacheco.sandbox.java.netflixoss.karyon.poc.common;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

public class AuthenticationServiceImpl implements AuthenticationService {

	public static final String AUTH_HEADER_NAME = "MY-USER-ID";

    @Override
    public Observable<Boolean> authenticate(HttpServerRequest<ByteBuf> request) {
        if (request.getHeaders().contains(AUTH_HEADER_NAME)) {
            return Observable.just(Boolean.TRUE);
        } else {
            return Observable.error(new IllegalArgumentException("Should pass a header: " + AUTH_HEADER_NAME));
        }
    }
}
