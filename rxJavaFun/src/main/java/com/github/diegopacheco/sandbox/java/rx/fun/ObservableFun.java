package com.github.diegopacheco.sandbox.java.rx.fun;

import rx.Observable;
import rx.functions.Action1;

public class ObservableFun {
	
	public static void hello(String... names) {
	    Observable.from(names).subscribe(new Action1<String>() {
			public void call(String t1) {
				System.out.println("Hello " + t1 + "!");
			}
	    });
	}
	
	public static void main(String[] args) {
		
		hello("Jorge");
		hello("Jorge","Bem","Jor");
		hello("Bateria");
		
	}
	
}
