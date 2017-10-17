package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Diego Pacheco
 *
 */
@SuppressWarnings("unchecked")
public class WhatYouPassISWhatYouGot {
	
	/**
	 * 
	 * @param <T> T means anything, so if you pass a Class of String T will be that.
	 * IF You a Pass a List of String T will be that. Basically what you pass is what you got.
	 * 
	 * In this case I'm putting a string inside the List of T assuming T will match as the same T.
	 * 
	 * @param t variable instance of T
	 * @return T 
	 */
	public static <T> T doSomething(T t){
		List<T> l = new ArrayList<T>();
		l.add( (T) new String("teste1") );
		return (T) l;
	}
	
	public static void useGenerics(){
		List<String> strings  =  new ArrayList<String>();		
		List<String> strings2 =  doSomething(strings);
		System.out.println(strings2);
	}
	
	public static void main(String[] args) {
		useGenerics();
	}
	
}
