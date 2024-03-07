package com.github.diegopacheco.reactor.poc.ctx;

import com.github.diegopacheco.reactor.poc.ctx.config.Mid;
import com.github.diegopacheco.reactor.poc.ctx.service.MonoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FluxMonoCtxApplicationTests {

	@Autowired
	private MonoService ms;

	@Test
	void contextLoads() {}

	//
	// MID Test -> Service (working 100%)
	//  I'm calling you passing the context(contextWrite).
	//  You can read it(Mono.deferContextual)
	//
	@Test
	void testCreateMidClientPropagation() {
		AtomicReference<Mid> ref = new AtomicReference<>();
		ref.set(Mid.newMid());

		System.out.println("Test.mono ID = " + ref.get());
		String result = ms.
				sum(10,20).
				contextWrite(Context.of(Mid.ID,ref.get())).
				block();

		System.out.println("Test.Final ID: " + ref.get());
		assertEquals("30",result);
	}

	// MID Service -> Test
	// I think it needs to pass a mono down!
	@Test
	void testNoMidPropagationFromClientButThereIsFromServer() {
		AtomicReference<Mid> ref = new AtomicReference<>();

		Mono<String> caller = Mono.deferContextual( ctx -> {
					Mid mid = ctx.get(Mid.ID);
					ref.set(mid);
					System.out.println("Test.mono ID = " + ref.get());
					return Mono.just("");
				});
		ms.sumWriter(10,20,caller);
		String result = caller.block();

		System.out.println("Test.Final ID: " + ref.get());
		assertEquals("30",result);
	}

}
