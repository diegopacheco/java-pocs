package com.github.diegopacheco.sandbox.java.jackson;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

public class JacksonMain {
	public static void main(String[] args) throws Throwable {
		
		Map<String,String> family = new ConcurrentHashMap<>();
		family.put("Gandalfy", "Cat");
		family.put("Melina",   "Cat");
		
		SimplePojo s1 = SimplePojo.getInstance();
		s1.setAge(33);
		s1.setName("Diego");
		s1.setFamily(family);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enableDefaultTyping(DefaultTyping.OBJECT_AND_NON_CONCRETE);
		
		String s1Json = mapper.writeValueAsString(s1);
		System.out.println("Simple Pojo as String : \n " + s1);
		System.out.println("Simple Pojo as Json   : \n " + s1Json);
		
		SimplePojo s2 = mapper.readValue(s1Json,SimplePojo.class);
		System.out.println("Simple Pojo2 as String : \n " + s2);
		
	}
}
