package com.github.diegopacheco.sandbox.java9.flow;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowRange implements Flow.Publisher<Integer> {

	final int start;
	final int end;
	final Executor executor;

	public FlowRange(int start, int count, Executor executor) {
		this.start = start;
		this.end = start + count;
		this.executor = executor;
	}

	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
		RangeSubscription sub = new RangeSubscription(subscriber, start, end, executor);
		sub.request(1);
	}

	static final class RangeSubscription extends AtomicLong implements Flow.Subscription, Runnable {
		final Flow.Subscriber<? super Integer> actual;

		final int end;

		final Executor executor;

		int index;
		boolean hasSubscribed;
		volatile boolean cancelled;
		volatile boolean badRequest;

		RangeSubscription(Flow.Subscriber<? super Integer> actual, int start, int end, Executor executor) {
			this.actual = actual;
			this.index = start;
			this.end = end;
			this.executor = executor;
		}

		@Override
		public void request(long n) {
			if (n <= 0L) {
				badRequest = true;
				n = 1;
			}
			for (;;) {
				long r = get();
				long u = r + n;
				if (u < 0L) {
					u = Long.MAX_VALUE;
				}
				if (compareAndSet(r, u)) {
					if (r == 0L) {
						executor.execute(this);
					}
					break;
				}
			}
		}

		@Override
		public void cancel() {
			this.cancelled = true;
		}

		@Override
		public void run() {
			Subscriber<? super Integer> a = actual;

			if (!hasSubscribed) {
				hasSubscribed = true;
				a.onSubscribe(this);
				if (decrementAndGet() == 0) {
					return;
				}
			}

			long r = get();
			int idx = index;
			int f = end;
			long e = 0L;

			for (;;) {
				while (e != r && idx != f) {
					if (cancelled) {
						return;
					}
					if (badRequest) {
						cancelled = true;
						a.onError(new IllegalStateException("3.9 violated: non-positive request received"));
						return;
					}

					a.onNext(idx);
					idx++;
					e++;
				}

				if (idx == f) {
					if (!cancelled) {
						a.onComplete();
					}
					return;
				}

				r = get();
				if (e == r) {
					index = idx;
					r = addAndGet(-e);
					if (r == 0L) {
						break;
					}
					e = 0L;
				}
			}
		}
	}
}