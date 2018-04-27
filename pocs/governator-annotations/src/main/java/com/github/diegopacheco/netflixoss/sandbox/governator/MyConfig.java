package com.github.diegopacheco.netflixoss.sandbox.governator;

import com.netflix.governator.annotations.AutoBindSingleton;
import com.netflix.governator.annotations.Configuration;

@AutoBindSingleton
public class MyConfig {
	
	@Configuration("config.host")
	private String host;
	
	@Configuration("config.port")
	private String port;
	
	public MyConfig() {}

	public MyConfig(String host, String port) {
		super();
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "MyConfig [host=" + host + ", port=" + port + "]";
	}
	
}
