package com.blogspot.diegopacheco.sandbox.github.java.akka.remote;

import java.util.Date;

import akka.actor.TypedActor;

/**
 * 
 * SystemDate 
 *
 * @author pacheco
 * @version 1.0
 * @since 13/12/2010
 *
 */
@SuppressWarnings("unchecked")
public class SystemDate extends TypedActor implements DateActor {
	
	public String currentDate(){
		return new Date().toString();
	}

}
