package com.github.diegopacheco.sandbox.java.unirest.sample;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
	public static void main(String[] args) throws UnirestException {
		
		System.out.println(
		    Unirest.post("http://httpbin.org/post")
		   .queryString("name", "Mark")
		   .field("last", "Polo")
		   .asJson().getBody().toString()
		 );
	}
}
