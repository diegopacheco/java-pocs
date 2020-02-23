package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
  
  public static void main(String args[]){
    SpringApplication.run(Main.class, args);
  }
  
  @Override
  public void run(String... args) {
    System.out.println("********* Works ******* " + args);
  }
}
