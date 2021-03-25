package com.github.diegopacheco.app;

import java.util.Arrays;

public class Main{

  public static void main(String args[])throws Exception{
    System.out.println("Args: " + Arrays.asList(args));
    if (args.length<=1){
      System.out.println("Doing Regular main");
      regularMain();
    }else{
      System.out.println("Doing Agent Dynamic Load");
      AgentLoader.run(args);
    }
  }

  private static void regularMain(){
    System.out.println("[APP] INIT APP.");
    System.out.println("[APP] My application is running... ");
    DataProcess.processData(2);
    System.out.println("[APP] DONE APP.");
  }

}
