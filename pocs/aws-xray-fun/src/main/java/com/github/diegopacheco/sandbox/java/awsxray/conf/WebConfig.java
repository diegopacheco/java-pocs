package com.github.diegopacheco.sandbox.java.awsxray.conf;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.strategy.DynamicSegmentNamingStrategy;

@Configuration
public class WebConfig {

	@Bean
	public Filter TracingFilter() {
		return new AWSXRayServletFilter(new DynamicSegmentNamingStrategy("MyApp", "*.com"));
	}

}
