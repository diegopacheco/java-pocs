package com.github.diegopacheco.sandbox.java.process;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;

import com.github.diegopacheco.sandbox.java.ssh.monad.Either;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

/**
 * ProcessEcecutor Enqueue ProcessRequests and run them in SERIAL way also providing Futures and Proper PIDMetadata for each process.
 * 
 * @author diegopacheco
 * @version 1.0
 *
 */
public class ProccessExecutor {
	
	private static Map<String,PIDMetadata> history =  
			new ConcurrentLinkedHashMap.Builder<String, PIDMetadata>()
				.maximumWeightedCapacity(1000)
				.build();
	
	private static ExecutorService executor = Executors.newSingleThreadExecutor();
	private static ProccessExecutor instance;

	private ProccessExecutor(){}
	
	public static synchronized ProccessExecutor getInstance() {
		if (instance==null) {
			instance = new ProccessExecutor();
		}
		return instance;
	}
	
	public CompletableFuture<Either<PIDMetadata,String>> execute(final ProcessRequest pr) {
		return makeCompletableFuture(executor.submit(new Callable<Either<PIDMetadata,String>>() {
			@Override
			public Either<PIDMetadata,String> call() throws Exception {
				 Either<PIDMetadata,String> result = executeCMD(pr);
				 result.print();
				 return result;
			}
		}));
	}
	
	private static <T> CompletableFuture<T> makeCompletableFuture(Future<T> future) {
    return CompletableFuture.supplyAsync(() -> {
        try {
            return future.get();
        } catch (InterruptedException|ExecutionException e) {
            throw new RuntimeException(e);
        }
    });
	}
	
	private static Either<PIDMetadata,String> executeCMD(ProcessRequest pr) {
		Process process = null;
		Either<PIDMetadata,String> either = null;
		PIDMetadata pim = new PIDMetadata();
		pim.setChecker(pr.getChecker());
		pim.setOwnerID("ProcessExecutor");
		pim.setTimestamp(new Date());
		history.put(pr.getName(), pim);

		try {
			process = Runtime.getRuntime().exec(pr.getCmd());
			pim.setPid(getPidOfProcess(process));
			process.waitFor();
			
			String content = IOUtils.toString(process.getInputStream(), Charset.defaultCharset());
			String error = IOUtils.toString(process.getErrorStream(), Charset.defaultCharset());
			
			if (error==null || "".equals(error) ) {
				pim.setProcessResult(Either.right(content));
				either = Either.right(pim);
			}	else {
				pim.setProcessResult(Either.left(error));
				either = Either.left(error);
			}
			process.destroy();
			return either;
		} catch (Exception e) {
			return Either.left(e.getMessage());
		} finally {
			if (process!=null && process.isAlive())
				process.destroy();
		}
	}

	private static String getCurrentPath() {
		try {
			return new File(".").getCanonicalPath();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static synchronized BigDecimal getPidOfProcess(Process p) {
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
	
	public List<PIDMetadata> getProcessHistory() {
		 List<PIDMetadata> historyResult = new ArrayList<>();
		 for(String key: history.keySet()) {
			  historyResult.add( history.get(key) );
		 }
		 return historyResult;
	}
	
	public static void main(String[] args) {
		ProccessExecutor pe = ProccessExecutor.getInstance();
		CompletableFuture<Either<PIDMetadata,String>> f1 = pe.execute(new ProcessRequest("list 1","ls -lsa", ProcessCheckers.NO_CHECKER));
		CompletableFuture<Either<PIDMetadata,String>> f2 = pe.execute(new ProcessRequest("list 2","ls -lsa", ProcessCheckers.NO_CHECKER));
		CompletableFuture<Either<PIDMetadata,String>> f3 = pe.execute(new ProcessRequest("list 3","ls -lsa", ProcessCheckers.NO_CHECKER));
		
		CompletableFuture.allOf(f1,f2,f3);
		
		System.out.println("Futures that are done - history: ");
		pe.getProcessHistory().forEach(System.out::println);
		
	}
	
}	
