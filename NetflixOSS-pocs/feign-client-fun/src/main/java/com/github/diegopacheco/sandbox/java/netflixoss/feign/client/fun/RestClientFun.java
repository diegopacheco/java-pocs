package com.github.diegopacheco.sandbox.java.netflixoss.feign.client.fun;

import java.util.List;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

public class RestClientFun {
	
	interface GitHub {
	    @RequestLine("GET /repos/{owner}/{repo}/contributors")
	    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
	}

	static class Contributor {
	  String login;
	  String url;
	  int contributions;
	}

	public static void main(String... args) {
		
		System.out.println("Call for: https://api.github.com/repos/netflix/feign/contributors");
		
	    GitHub github = Feign.builder()
	                       .decoder(new GsonDecoder())
	                       .target(GitHub.class, "https://api.github.com");

	    List<Contributor> contributors = github.contributors("netflix", "feign");
	    for (Contributor contributor : contributors) {
	       System.out.println(contributor.login + " (" + contributor.contributions + ") " + contributor.url);
	    }
  }
	
}
