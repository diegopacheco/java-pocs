package com.github.diegopacheco.sandbox.java.process;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;

import com.github.diegopacheco.sandbox.java.ssh.concurrent.CompletableFutureUtils;
import com.github.diegopacheco.sandbox.java.ssh.concurrent.Counter;
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
	
	private static AtomicInteger id = new AtomicInteger(0);
	private static Map<String,PIDMetadata> history =  
			new ConcurrentLinkedHashMap.Builder<String, PIDMetadata>()
				.maximumWeightedCapacity(1000)
				.build();
	
	private static Map<String,Counter> metrics = new ConcurrentHashMap<>();
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
		return CompletableFutureUtils.makeCompletableFutureSync(executor.submit(new Callable<Either<PIDMetadata,String>>() {
			@Override
			public Either<PIDMetadata,String> call() throws Exception {
				 Either<PIDMetadata,String> result = executeCMD(pr);
				 return result;
			}
		}));
	}
	
	private Either<PIDMetadata,String> executeCMD(ProcessRequest pr) {
		Process process = null;
		Either<PIDMetadata,String> either = null;
		PIDMetadata pim = new PIDMetadata();
		pim.setChecker(pr.getChecker());
		pim.setOwnerID("ProcessExecutor");
		pim.setTimestamp(new Date());
		history.put(pr.getName() + "_" + id.getAndIncrement(), pim);

		try {
			process = Runtime.getRuntime().exec(pr.getCmd());
			pim.setPid(getPidOfProcess(process));
			process.waitFor();
			
			String content = IOUtils.toString(process.getInputStream(), Charset.defaultCharset());
			String error = IOUtils.toString(process.getErrorStream(), Charset.defaultCharset());
			
			if (error==null || "".equals(error) ) {
				pim.setProcessResult(Either.right(content));
				either = Either.right(pim);
				incOkCounter(pr);
			}	else {
				pim.setProcessResult(Either.left(error));
				either = Either.left(error);
				incErrorCounter(pr);
			}
			
			process.destroy();
			return either;
			
		} catch (Exception e) {
			
			incErrorCounter(pr);
			return Either.left(e.getMessage());
			
		} finally {
			
			if (process!=null && process.isAlive())
				process.destroy();
		}
	}

	private void incOkCounter(ProcessRequest pr) {
		Counter counter = metrics.get(pr.getName());
		if(counter==null) {
			counter = new Counter();
			metrics.put(pr.getName(), counter);
		}
		counter.incrementOk();
	}

	private void incErrorCounter(ProcessRequest pr) {
		Counter counter = metrics.get(pr.getName());
		if(counter==null) {
			counter = new Counter();
			metrics.put(pr.getName(), counter);
		}
		counter.incrementError();
	}

	private BigDecimal getPidOfProcess(Process p) {
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
	
	public Map<String,Counter> getMetrics() {
		 return Collections.unmodifiableMap(metrics);
	}
	
	public void shutdown() {
		executor.shutdown();
	}
	
	public static void main(String[] args) throws Throwable {
		ProccessExecutor pe = ProccessExecutor.getInstance();
		CompletableFuture<Either<PIDMetadata,String>> f1 = pe.execute(new ProcessRequest("list","ls -lsa", ProcessCheckers.PID_CHECKER));
		CompletableFuture<Either<PIDMetadata,String>> f2 = pe.execute(new ProcessRequest("list","ls -lsa", ProcessCheckers.NO_CHECKER));
		CompletableFuture<Either<PIDMetadata,String>> f3 = pe.execute(new ProcessRequest("list","ls -lsa", ProcessCheckers.NO_CHECKER));
		CompletableFuture<Either<PIDMetadata,String>> f4 = pe.execute(new ProcessRequest("wait","sleep 5", ProcessCheckers.NO_CHECKER));
		CompletableFuture<Either<PIDMetadata,String>> f5 = pe.execute(new ProcessRequest("error","blablabla", ProcessCheckers.NO_CHECKER));
		
		System.out.println("Wait for all and aggrehate: ");
		CompletableFutureUtils.waitAndAggregate(f1,f2,f3,f4,f5).join().forEach( r -> System.out.println(r.getValue()));
		
		System.out.println("Futures that are done - history: ");
		pe.getProcessHistory().forEach(System.out::println);
		
		System.out.println("Metrics: ");
		pe.getMetrics().forEach(  (k,v) ->  System.out.println("task: " + k + " ok/erros: " + v) );
		
		System.out.println("Process Outputs: ");
		pe.getProcessHistory().forEach( p-> p.getProcessResult().print() );
		
		System.out.println("is first pid running ? " + pe.getProcessHistory().get(0).getChecker().hasCompleted( pe.getProcessHistory().get(0)));
		
		pe.shutdown();
	}
	
}	
