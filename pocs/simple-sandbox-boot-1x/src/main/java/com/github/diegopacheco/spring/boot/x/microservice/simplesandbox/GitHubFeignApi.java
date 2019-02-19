package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("githubFC")
public interface GitHubFeignApi {
	
  @RequestMapping(path = "https://api.github.com/users/{user}/repos", method = RequestMethod.GET)
  public GithubRepo getProductFromRestAPI(@PathVariable(value = "user") String user);
	
}
