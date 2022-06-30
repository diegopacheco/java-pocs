package com.github.diegopacheco.sandboxspring.controller;

import groovy.lang.Grab;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/{a}")
	public String eval(@PathVariable("a") String a) {
		return "Groovy Eval: " + evalGroovy(a);
	}

	private String evalGroovy(String parameter){
		try{
			final GroovyClassLoader classLoader = new GroovyClassLoader();

			final StringBuilder groovyScript = new StringBuilder();
			groovyScript.append("@Grab(group='org.apache.commons', module='commons-lang3', version='3.12.0')");
			groovyScript.append("import org.apache.commons.lang3.StringUtils;");
			groovyScript.append("class Sample {");
			groovyScript.append("  String sayIt(name) { \"Groovy says: Cool $name! isEmpty? \" + StringUtils.isEmpty(\"$name\")  }");
			groovyScript.append("}");

			Class groovy = classLoader.parseClass(groovyScript.toString());
			GroovyObject groovyObj = (GroovyObject) groovy.getDeclaredConstructors()[0].newInstance();
			return (String)groovyObj.invokeMethod("sayIt", new Object[] { parameter });

		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}

