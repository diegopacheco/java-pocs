package com.github.diegopacheco.reactor.poc.ctx.controller;

import com.github.diegopacheco.reactor.poc.ctx.config.ThreadLocalMID;
import com.github.diegopacheco.reactor.poc.ctx.service.MonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class ThreadLocalController {

    @Autowired
    private MonoService service;

    @GetMapping("/")
    public String index() throws Exception {
        ThreadLocalMID mid = ThreadLocalMID.newMid();
        AtomicReference<ThreadLocalMID> ref = new AtomicReference<>();
        ref.set(mid);

        System.out.println("Controller.mono ID = " + mid);
        String result = service.
                sumThreadLocal(10,20).
                contextWrite(Context.of(ThreadLocalMID.ID,ref.get())).
                subscribeOn(Schedulers.boundedElastic()).toFuture().get(60L, TimeUnit.SECONDS);

        System.out.println("Controller.Final ID: " + mid);
        return "Mid: " + mid + " Result: " + result;
    }
}
