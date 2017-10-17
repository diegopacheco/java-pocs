package com.github.diegopacheco.sandbox.java9.pubsub;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber<T> implements Subscriber<T> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1); // a value of Long.MAX_VALUE may be considered as effectively unbounded
	}

	@Override
	public void onNext(T item) {
		System.out.println("Got : " + item);
		subscription.request(1); // a value of Long.MAX_VALUE may be considered as effectively unbounded
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Done");
	}

}