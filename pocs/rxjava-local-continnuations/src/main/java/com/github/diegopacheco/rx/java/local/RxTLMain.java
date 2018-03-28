package com.github.diegopacheco.rx.java.local;

import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;

//import rx.Observable;
//import rx.plugins.RxJavaHooks;

/**
 * RxJavaHooks allow you to create "interceptors" on Rx but was deprecated on 2.0 - only works on 1.0.
 * 
 * @author diegopacheco
 * @version 1.0
 *
 */
public class RxTLMain {
	
	public static void main(String[] args) {
		
		// RX 1.X
		/*
		RxJavaHooks.setOnObservableCreate(o -> { 
	    System.out.println("Creating " + o.getClass());
	    return o; 
		});
		
		try {
	    Observable.range(1, 10)
	    .map(v -> v * 2)
	    .filter(v -> v % 4 == 0)
	    .subscribe(System.out::println);
		} finally {
	    RxJavaHooks.reset();
		}
		*/
		
		// RX 2.X
		
		RxJavaPlugins.reset();
		RxJavaPlugins.setErrorHandler( (Throwable e) ->  System.out.println("Hacked " + e) );
		
		Observable.error(new RuntimeException())
		.map(v -> "" + v)
		.doOnError( e -> System.out.println("Deu ruim! " + e))
		.subscribe(System.out::println);
		
	}
}
