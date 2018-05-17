package com.github.diegopaheco.sandbox.java8.enumz.consumers;

import java.util.Date;

public class DatePrinter {
	 public static void print(String content) {
		 System.out.println(new Date().toString() + " " + content);
	 }
}
