package com.github.diegopacheco.sandbox.java.vault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(MyVaultConf.class)
public class VaultApp implements CommandLineRunner {
	
  private final MyVaultConf conf;

  public VaultApp(MyVaultConf configuration) {
      this.conf = configuration;
  }
	
	@Autowired
	private ServiceUsingSecrets service;
	
  private static Logger LOG = LoggerFactory.getLogger(VaultApp.class);

  public static void main(String[] args) {
      LOG.info("Console Application started");
      SpringApplication.run(VaultApp.class, args);
      LOG.info("Console Application FINISHED");
  }

  @Override
  public void run(String... args) {
  	System.out.println("Reading sensible data from Vault");
  	System.out.println("RDS: ");
  	System.out.println("** username: " + conf.getUsername());
  	System.out.println("** password: " + conf.getPassword());
  	System.out.println("END. ");
  	
  	System.out.println(service.readSensibleData());
  }
  
}