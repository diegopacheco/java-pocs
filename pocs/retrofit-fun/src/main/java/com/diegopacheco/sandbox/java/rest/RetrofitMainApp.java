package com.diegopacheco.sandbox.java.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitMainApp {
	public static void main(String[] args) throws Exception {

		Retrofit retrofit = new Retrofit.
									Builder().
									baseUrl("https://api.github.com/").
									addConverterFactory(JacksonConverterFactory.create()).
									build();
		
		System.out.println("Retrofit: " + retrofit);
		
		GitHubService service = retrofit.create(GitHubService.class);
		System.out.println("GitHub Service: " + service);
		
		Call<List<Repo>> repos = service.listRepos("octocat");
		System.out.println("Awnser: " + repos.execute().body());

	}
}
