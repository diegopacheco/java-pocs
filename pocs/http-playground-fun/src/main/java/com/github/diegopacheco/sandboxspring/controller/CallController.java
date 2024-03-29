package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.http.DefaultContentTypeInterceptor;
import okhttp3.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CallController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/call")
	public String call() throws Exception {

		OkHttpClient client = new OkHttpClient().newBuilder()
				.addInterceptor(
						new DefaultContentTypeInterceptor("application/json"))
				.followRedirects(true)
				.build();

		RequestBody body = new FormBody.Builder()
				.add("name", "diego")
				.build();

		Request request = new Request.Builder()
				.url("http://127.0.0.1:8082/post")
				.addHeader("accept","application/json")
				.method("POST",body)
				.build();

		Call call = client.newCall(request);
		Response response = call.execute();
		response.close();

		return response.toString();
	}

}

