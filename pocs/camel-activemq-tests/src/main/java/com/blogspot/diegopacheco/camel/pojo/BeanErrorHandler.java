package com.blogspot.diegopacheco.camel.pojo;

import org.springframework.stereotype.Service;

@Service("BeanErrorHandler")
public class BeanErrorHandler {
	public void handle(Exception ex,String msg){
		System.out.println("Exception: " + ex + " Msg: " + msg);
	}
}
