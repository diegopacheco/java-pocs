package com.github.diegopacheco.sandbox.java9.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

public class TestFlowSubscriber<T> implements Flow.Subscriber<T> {

	protected final List<T> values;
	protected final List<Throwable> errors;
	protected int completions;
	protected Flow.Subscription subscription;
	protected final CountDownLatch done;

	public TestFlowSubscriber() {
		this.values = new ArrayList<>();
		this.errors = new ArrayList<>();
		this.done = new CountDownLatch(1);
	}

	@Override
	public final void onSubscribe(Flow.Subscription subscription) {
		this.subscription = subscription;
		onStart();
	}

	public void onStart() {
		subscription.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(T item) {
		values.add(item);
	}

	@Override
	public void onError(Throwable throwable) {
		errors.add(throwable);
		done.countDown();
	}

	@Override
	public void onComplete() {
		completions++;
		done.countDown();
	}

	public final List<T> values() {
		return values;
	}

	public final List<Throwable> errors() {
		return errors;
	}

	public final int completions() {
		return completions;
	}

	public final boolean await(long timeout, TimeUnit unit) throws InterruptedException {
		return done.await(timeout, unit);
	}
}