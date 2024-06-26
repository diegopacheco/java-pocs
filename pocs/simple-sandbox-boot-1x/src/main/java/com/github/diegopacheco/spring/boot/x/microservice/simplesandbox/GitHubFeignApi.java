package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient(name = "gitHubfeignApi", url = "https://api.github.com") 
public interface GitHubFeignApi {

	@RequestMapping(path = "/users/{username}/repos", method = RequestMethod.GET)
	@HystrixCommand
	public List<GithubRepo> getUserRepos(@PathVariable(value = "username") String username);

}
