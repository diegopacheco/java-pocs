package com.github.diegopacheco.sandbox.java.fp.fun;

import fj.data.Array;  
import static fj.data.Array.array;  
import static fj.function.Integers.add;  

public final class Array_map {  
  public static void main(final String[] args) {  
   
	  final Array<Integer> a = array(1, 2, 3);  
      final Array<Integer> b = a.map(add.f(1));  
      
      System.out.println(b.toCollection());  
  }
}  
