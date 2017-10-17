package com.github.diegopacheco.sandbox.java.unirest.fun;

import com.mashape.unirest.http.Unirest;

public class MainUnirestFun {
	public static void main(String[] args) throws Throwable {
		
		String result = Unirest.post("http://httpbin.org/post")
		  .queryString("name", "Mark")
		  .field("last", "Polo")
		  .asJson().getBody().toString();
		System.out.println(result);
		
		result = Unirest.get("http://httpbin.org/{method}")
		  .routeParam("method", "get")
		  .queryString("name", "Mark")
		  .asJson().getBody().toString();
		System.out.println(result);
	}
}
