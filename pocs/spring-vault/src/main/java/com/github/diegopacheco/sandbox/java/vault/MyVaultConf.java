package com.github.diegopacheco.sandbox.java.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("microservicex")
public class MyVaultConf {
  
	@Value("${microservicex.rdsusername}")
	private String rdsusername;
	
	@Value("${microservicex.rdspassword}")
  private String rdspassword;
  
	public String getUsername() {
		return rdsusername;
	}
	public void setUsername(String username) {
		this.rdsusername = username;
	}
	
	public String getPassword() {
		return rdspassword;
	}
	public void setPassword(String password) {
		this.rdspassword = password;
	}
  
}
