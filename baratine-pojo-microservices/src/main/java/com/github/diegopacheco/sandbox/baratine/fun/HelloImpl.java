package com.github.diegopacheco.sandbox.baratine.fun;

import io.baratine.core.Service;

@Service("public:///hello")
public class HelloImpl implements Hello {
	public String hello() {
		return "hello";
	}
}