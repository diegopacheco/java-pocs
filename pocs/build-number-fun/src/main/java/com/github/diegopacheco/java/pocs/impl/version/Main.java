package com.github.diegopacheco.java.pocs.impl.version;

public class Main{
  public static void main(String args[]){
    System.out.println("Implementation Version: " +
            Main.class.getPackage().getImplementationVersion());
  }
}
