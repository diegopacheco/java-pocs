package com.github.diegopacheco.pitest.fun;

public class SimpleTransformer {
	
	public int toNumber(int a) {
		  if (a==0) return a+1;
		  else return 0; 
	}
	
	public int compare(int a,int b){
		if (a>=b) return 1;
		if (a==-1) return -1;
		if (a==b) return 0;
		return 3;
	}
	
}
