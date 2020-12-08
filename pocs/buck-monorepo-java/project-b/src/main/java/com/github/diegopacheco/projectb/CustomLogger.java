package com.github.diegopacheco.projectb;

import java.util.Date;

public class CustomLogger {

  public static void log(String msg) throws Exception {
    System.out.println(new Date() + " > " + msg);
  }

}