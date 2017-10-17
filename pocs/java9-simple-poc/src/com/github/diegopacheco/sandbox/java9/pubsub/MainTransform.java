package com.github.diegopacheco.sandbox.java9.pubsub;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class MainTransform {

	public static void main(String[] args) {

		// Create PublisherMyTransformProcessor
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

		// Create Processor and Subscriber
		MyTransformProcessor<String, String> filterProcessor = new MyTransformProcessor<>(s -> String.valueOf( new Integer(s).intValue()  + 1) );

		MyTransformProcessor<String, Integer> transformProcessor = new MyTransformProcessor<>(s -> Integer.parseInt(s));

		MySubscriber<Integer> subscriber = new MySubscriber<>();

		// Chain Processor and Subscriber
		publisher.subscribe(filterProcessor);
		filterProcessor.subscribe(transformProcessor);
		transformProcessor.subscribe(subscriber);

		System.out.println("Publishing Items...");
		String[] items = { "1", "2", "3" };
		Arrays.asList(items).stream().forEach(i -> publisher.submit(i));
		publisher.close();

	}

}
