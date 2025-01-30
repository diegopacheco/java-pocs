package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.contract.v1.GreetingContract;
import org.springframework.web.bind.annotation.*;

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

	@Override
	@GetMapping
	@RequestMapping("/lang/{langName}")
	public String greet(@RequestParam("langName") String langName) {
		return langs.getOrDefault(langName, langs.get("en"));
	}

	//@Override
	//@GetMapping
	/*
	public String findGreetingLanguage(String lang) {
		return "";
	}
	*/
}

