package com.github.diegopacheco.sandbox.java9.pubsub;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyTransformProcessor<T, R> extends SubmissionPublisher<R> implements Processor<T, R> {

	private Function function;
	private Subscription subscription;

	public MyTransformProcessor(Function<? super T, ? extends R> function) {
		super();
		this.function = function;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		submit((R) function.apply(item));
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		close();
	}
}