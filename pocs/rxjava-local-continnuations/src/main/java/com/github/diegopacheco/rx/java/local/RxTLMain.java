package com.github.diegopacheco.rx.java.local;

import rx.Observable;
import rx.plugins.RxJavaHooks;

/**
 * RxJavaHooks allow you to create "interceptors" on Rx but was deprecated on 2.0 - only works on 1.0.
 * 
 * @author diegopacheco
 * @version 1.0
 *
 */
public class RxTLMain {
	
	public static void main(String[] args) {
		
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
		
	}
}
