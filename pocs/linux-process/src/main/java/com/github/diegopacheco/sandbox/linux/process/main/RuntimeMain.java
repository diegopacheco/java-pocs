package com.github.diegopacheco.sandbox.linux.process.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RuntimeMain {
	public static void main(String[] args) {

		   StringBuffer output = new StringBuffer();
		   Process p;
		
			try {
				p = Runtime.getRuntime().exec(new String[]{"bash","-c","ps aux | grep java | wc -l"});
				p.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

				String line = "";
				while ((line = reader.readLine())!= null) {
					output.append(line + "\n");
				}
				System.out.println("There are " + output.toString() + " java process running... ");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
	}
}
