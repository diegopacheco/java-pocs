package com.github.diegopacheco.sandbox.java.vault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class VaultApp implements CommandLineRunner {
	
  static {
    System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
  }
	
	@Autowired
	private Example example;
	
  private static Logger LOG = LoggerFactory.getLogger(VaultApp.class);

  public static void main(String[] args) {
      LOG.info("Console Application started");
      SpringApplication.run(VaultApp.class, args);
      LOG.info("Console Application FINISHED");
  }

  @Override
  public void run(String... args) {
  	System.out.println(example.readSensibleData());
  }
  
}