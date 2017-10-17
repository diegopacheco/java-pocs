package com.github.diegopacheco.sandbox.java.netflixoss.karyon.poc.common;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

public interface AuthenticationService {
    Observable<Boolean> authenticate(HttpServerRequest<ByteBuf> request);
}
