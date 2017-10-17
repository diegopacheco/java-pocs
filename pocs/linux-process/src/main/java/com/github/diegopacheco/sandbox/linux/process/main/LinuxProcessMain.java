package com.github.diegopacheco.sandbox.linux.process.main;

import java.io.File;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;

public class LinuxProcessMain {
	public static void main(String[] args){
		Process process = null;
		try{
			List<String> command = Lists.newArrayList();
			command.add("bash");
			command.add("-c");
			command.add("ps aux | grep java | wc -l");
			
			ProcessBuilder builder = new ProcessBuilder(command);
			builder.directory(new File("/"));
			builder.redirectErrorStream(true);
			
			process = builder.start();
			Thread.sleep(5000);
			
			int code = process.exitValue();
			String result = new String(ByteStreams.toByteArray(process.getInputStream()),Charsets.UTF_8);
	        if (code == 0) {
	        	System.out.println("There are " + result.trim() + " java process running");
	        }else {
	        	String error = new String(ByteStreams.toByteArray(process.getErrorStream()),Charsets.UTF_8);
	        	System.out.println("Error: " + code);
	        	System.out.println("Error: " + error);
	        	System.out.println("Outr: "  + result);
	        }
	        
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			process.destroy();
		}
	}
}

