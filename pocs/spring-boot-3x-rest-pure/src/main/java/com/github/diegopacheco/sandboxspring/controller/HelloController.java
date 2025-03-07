package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.contract.v1.GreetingContract;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	// curl -i http://localhost:8080/find\?langName\=it
	@Override
	@GetMapping("/find")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String findGreetingLanguage(@RequestParam(value = "langName") String lang) {
		if (!langs.containsKey(lang)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Language not found");
		}
		return langs.get(lang);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleNotFoundException(ResponseStatusException ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("version", "V1");
		return new ResponseEntity<>(ex.getReason(), headers, ex.getStatusCode());
	}

}

