package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="gitHubfeignApi", url="https://api.github.com", fallback = GitHubFeignApi.GithubClientFallback.class)
public interface GitHubFeignApi {
	
  @RequestMapping(path = "/users/{username}/repos", method = RequestMethod.GET)
  public List<GithubRepo> getUserRepos(@PathVariable(value = "username") String username);
	
  @Component
  public static class GithubClientFallback implements GitHubFeignApi {
      @Override
      public List<GithubRepo> getUserRepos(String username){
      	  GithubRepo gr = new GithubRepo();
      	  gr.setFull_name("Fallback: Some dummy response!");
          return Arrays.asList(gr);
      }
  }
  
}
