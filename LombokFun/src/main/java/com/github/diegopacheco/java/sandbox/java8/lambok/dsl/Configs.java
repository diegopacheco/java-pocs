package com.github.diegopacheco.java.sandbox.java8.lambok.dsl;

import lombok.ToString;
import lombok.experimental.Builder;

public 
	@Builder(fluent=true,builderMethodName="dsl")
	@ToString
class Configs {
	private String url;
	private String host;
	private String os;
}
