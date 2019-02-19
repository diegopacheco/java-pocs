package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

	@Value("${name:World}")
	private String name;
	
	@Autowired
	private GitHubFeignApi githubApi;
	
	public String getHelloMessage() {
		List<GithubRepo> results = githubApi.getUserRepos("diegopacheco");
		return "Hello " + this.name + " - github: " + results;
	}

}