package com.github.diegopacheco.sandbox.java.fp.fun;

import static fj.data.List.list;
import fj.F;
import fj.data.List;
    
public final class Filter {  
  public static void main(final String[] args) {  

      final List<Integer> p1 = list(1,2,3,4,5,6,7).filter(new F<Integer, Boolean>() {		
		 public Boolean f(Integer i) { return (i > 4); }
	  });      

      System.out.println(p1.toCollection());  
  }  
}  