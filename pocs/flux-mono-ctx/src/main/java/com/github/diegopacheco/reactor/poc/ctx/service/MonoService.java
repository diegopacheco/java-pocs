package com.github.diegopacheco.reactor.poc.ctx.service;

import com.github.diegopacheco.reactor.poc.ctx.config.Mid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MonoService {

    @Autowired
    private LogService log;

    public Mono<String> sum(Integer a, Integer b) {

        String sum = a + b + "";
        AtomicReference<Mid> ref = new AtomicReference<>();

        Mono<String> result = Mono.
                deferContextual(ctx -> {
                    Mid mid = null;
                    try {
                        // client passed the MID - propagating
                        mid = ctx.get(Mid.ID);
                    } catch (NoSuchElementException nse) {
                        // client DID NOT pass the MID - creating
                        mid = Mid.newMid();
                        System.out.println("MonoService.create new MID " + mid);
                    }

                    ref.set(mid);
                    System.out.println("MonoService.mono ID = " + ref.get());

                    Mono<String> resultInternal = Mono.just(sum);
                    log.log("MonoService.after mono ID = ", ref.get());

                    return resultInternal;
                });
        return result;
    }

    public Mono<String> sumRef(Integer a, Integer b, AtomicReference<Mid> refCallback) {

        final String sum = a + b + "";
        refCallback.set(Mid.newMid());

        Mono<String> result = Mono.
                deferContextual(ctx -> {
                    Mid mid = null;
                    try {
                        // client passed the MID - propagating
                        mid = ctx.get(Mid.ID);
                    } catch (NoSuchElementException nse) {
                        // client DID NOT pass the MID - creating
                        mid = refCallback.get();
                        System.out.println("MonoService.create new MID " + mid);
                    }

                    System.out.println("MonoService.mono ID = " + mid);

                    Mono<String> resultInternal = Mono.just(sum);
                    log.log("MonoService.after mono ID = ", mid);

                    return resultInternal;
                });
        return result;
    }

}
