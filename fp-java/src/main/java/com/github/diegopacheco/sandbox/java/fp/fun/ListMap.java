package com.github.diegopacheco.sandbox.java.fp.fun;

import fj.data.List;  
import static fj.data.List.list;  
import static fj.function.Integers.add;  
  
public final class ListMap {  
  public static void main(final String[] args) {  

	  final List<Integer> a = list(1, 2, 3);  
      final List<Integer> b = a.map(add.f(3));  
      
      System.out.println(b.toCollection());  
  }  
}  