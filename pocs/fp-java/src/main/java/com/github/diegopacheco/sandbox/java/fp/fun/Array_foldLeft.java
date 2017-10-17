package com.github.diegopacheco.sandbox.java.fp.fun;

import fj.data.Array;  
import static fj.data.Array.array;  
import static fj.function.Integers.add;  
  
public final class Array_foldLeft {  
  public static void main(final String[] args) {  
    
	  final Array<Integer> a = array(1, 2, 3, 4, 5, 6);  
      final int b = a.foldLeft(add, 0);  
      
      System.out.println(b);  
  }  
}  