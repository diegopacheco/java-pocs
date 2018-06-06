package com.github.diegopacheco.sandbox.java.ssh;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.github.diegopacheco.sandbox.java.ssh.monad.Either;

public class SSHManager {
	
	public static Either<String> execute(String... cmd) {
		Process process = null;
		Either<String> either = null;

		try {
			process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			String content = IOUtils.toString(process.getInputStream(), Charset.defaultCharset());
			String error = IOUtils.toString(process.getErrorStream(), Charset.defaultCharset());
			
			if (error==null || "".equals(error) )
				either = Either.right(content);
			else
				either = Either.left(error);
			
			process.destroy();
			return either;
		} catch (Exception e) {
			return Either.left(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		Either<String> result = SSHManager.execute("ls","-lsa");
		
		if(result.hasError())
			System.out.println(result.getError());
		else	
			System.out.println(result.getValue());
		
	}
	
}
