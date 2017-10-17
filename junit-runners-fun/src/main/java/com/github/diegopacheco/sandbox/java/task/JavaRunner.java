package com.github.diegopacheco.sandbox.java.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class JavaRunner {

	public void run(String klass) {
		try{
			File base = new File(".");
			File file = new File( base.getCanonicalPath() + "/build/libs/" + klass);
			
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", file.getCanonicalPath() );
			//ProcessBuilder pb = new ProcessBuilder("ls", "-lsa");
			Map<String, String> env = pb.environment();
			env.put("VAR1", "myValue");
			
			pb.redirectErrorStream(true);
			//File log = new File("log.txt");
			//pb.redirectOutput(Redirect.appendTo(log));
			Process p = pb.start();
			assert pb.redirectInput() == Redirect.PIPE;
			assert p.getInputStream().read() == -1;
			//assert pb.redirectOutput().file() == log;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ( (line = reader.readLine()) != null) {
			   builder.append(line);
			   builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			System.out.println("DONE");
			System.out.println(result);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	public static void main(String[] args) {

		JavaRunner jr = new JavaRunner();
		jr.run("junit-runners-fun.jar");

	}

}
