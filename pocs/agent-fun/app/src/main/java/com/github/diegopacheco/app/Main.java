package com.github.diegopacheco.app;

public class Main{

  public static void main(String args[]){
    System.out.println("[APP] INIT APP.");
    System.out.println("[APP] My application is running... ");
    processData(2);
    System.out.println("[APP] DONE APP.");
  }

  public static void processData(int amount){
    System.out.println("[Application] Successful process of ["+amount+"] GB of data!");
  }

}
