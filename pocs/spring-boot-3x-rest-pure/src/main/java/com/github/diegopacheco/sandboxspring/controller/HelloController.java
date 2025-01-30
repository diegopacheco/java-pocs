package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.contract.v1.GreetingContract;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class HelloController implements GreetingContract {

	Map<String,String> langs = new ConcurrentHashMap<>();

	public HelloController(){
		langs.put("en","Hi");
		langs.put("es","Hola");
		langs.put("pt","Eae");
	}

	//  http://localhost:8080/lang?langName=pt
	@Override
	@GetMapping("/lang")
	public String greet(@RequestParam(value = "langName", defaultValue = "en") String langName) {
		return langs.getOrDefault(langName, langs.get("en"));
	}

	//  http://localhost:8080/find?langName=it
	@Override
	@GetMapping("/find")
	public String findGreetingLanguage(@RequestParam(value = "langName") String lang) {
		if (!langs.containsKey(lang)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Language not found");
		}
		return langs.get(lang);
	}

}

