package com.github.diegopacheco.sandbox.java.ssh;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;

import com.github.diegopacheco.sandbox.java.process.PIDMetadata;
import com.github.diegopacheco.sandbox.java.process.ProcessChecker;
import com.github.diegopacheco.sandbox.java.ssh.monad.Either;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

/**
 * SSHManager runs SSH and SHELL commands on Linux. Adds proper metadata in order to have proper observability.
 * 
 * @author diegopacheco
 *
 */
public class SSHManager {
	
	private static Map<String,PIDMetadata> history =  
		new ConcurrentLinkedHashMap.Builder<String, PIDMetadata>()
			.maximumWeightedCapacity(1000)
			.build();

	private static AtomicInteger pidCounter = new AtomicInteger(0);
	
	public synchronized static Either<String> execute(String name,String cmd,ProcessChecker checker) {
		String wrapperCMD = " nohup " + cmd + " &";
		System.out.println(wrapperCMD);
		
		PIDMetadata pim = new PIDMetadata();
		pim.setChecker(checker);
		pim.setOwnerID("SSHManager");
		pim.setTimestamp(new Date());
		pim.setPidFile( getCurrentPath() +  "/pid_" + pidCounter.incrementAndGet());

		return executeCMD(name,pim,"sh", "-c", wrapperCMD);
	}
	
	private static synchronized Either<String> executeCMD(String name,PIDMetadata pim ,String... cmd) {
		Process process = null;
		Either<String> either = null;

		try {
			process = Runtime.getRuntime().exec(cmd);
			
			pim.setPid(getPidOfProcess(process));
			pim.setLogFile(getCurrentPath() + "/nooup_" + pim.getPid() + ".out");
			
			history.put(name, pim);
			
			process.waitFor();
			
			// not sure if this is safe.
		  Runtime.getRuntime().exec("echo " + pim.getPid() + " > " + pim.getPidFile()).waitFor();
		  Runtime.getRuntime().exec("mv nooup.out nooup_" + pim.getPid() + ".out").waitFor();
		  
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
		} finally {
			if (process!=null && process.isAlive())
				process.destroy();
		}
	}
	
	public static String getCurrentPath() {
		try {
			return new File(".").getCanonicalPath();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static synchronized BigDecimal getPidOfProcess(Process p) {
	    long pid = -1;
	    try {
	      if (p.getClass().getName().equals("java.lang.UNIXProcess")) {
	        Field f = p.getClass().getDeclaredField("pid");
	        f.setAccessible(true);
	        pid = f.getLong(p);
	        f.setAccessible(false);
	      }
	    } catch (Exception e) {
	      pid = -1;
	    }
	    return new BigDecimal(pid);
	 }
	 
	 public static synchronized void printProcessHistory() {
		 for(String key: history.keySet()) {
			  System.out.println(history.get(key));
		 }
	 }
	
	public static void main(String[] args) {
		
		SSHManager.execute("List_dir_task_1","ls -lsa",new PositiveChecker()).print();
		SSHManager.execute("List_dir_task_2","ls -lsa",new PositiveChecker()).print();
		
		SSHManager.printProcessHistory();
	}
	
}
