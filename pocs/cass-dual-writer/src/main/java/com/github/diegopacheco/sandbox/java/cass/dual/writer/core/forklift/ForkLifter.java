package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift;

import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.CassDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.HashComparableRow;

public class ForkLifter {
	
	private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	private static ForkLifter instance;
	private static Queue<DaoPairs> daos = new ConcurrentLinkedQueue<>();
	
	private ForkLifter() {}
	
	public static synchronized ForkLifter getInstance() {
		if (instance==null) {
			instance = new ForkLifter();
			
			executor.scheduleAtFixedRate( () -> {
				
				try {
						
						if (daos==null || daos.size()==0){
							System.out.println("NO DAOs to ForkLift. ");
						}else {
							System.out.println("Fork Lifting... " + daos.size() + " daos");
							forkLiftDaos();
						}	
					
				}catch(Exception e) {
					 System.out.println("ERROR: " + e);
				}
				
			}, 0, 30, TimeUnit.SECONDS);
			
		}
		return instance;
	}
	
	private static void forkLiftDaos() {
		 long init = System.currentTimeMillis();
		 
		 daos.forEach(  d -> forkLift(d)  );
		 
		 long end = System.currentTimeMillis();
		 long millis = (end-init);
		 String time = TimeUtils.format(millis);
		 System.out.println("DONE Fork Lifting took " + time + " \n");
	}
	
	private static void forkLift(DaoPairs daoPair) {
		System.out.println("Forklifiting " + daoPair);
		
		Map<String,HashComparableRow> dataFrom = getAllDataAsRow(daoPair.getFrom());
		Integer originalSize = dataFrom.size();
		System.out.println("Got: " + dataFrom.size() + " from dao");
		
		Map<String,HashComparableRow> dataTo = getAllDataAsRow(daoPair.getTo());
		System.out.println("Got: " + dataTo.size() + " to dao");
		
		for(String key : dataFrom.keySet()) {
			 if (dataTo.get(key)!=null)
				 dataFrom.remove(key);
		}
		
		if (dataFrom.size()==0) { 
			System.out.println("All in SYNC - Nothing to do!");
		}else {
			System.out.println(dataFrom.size() + " ROW to Be Migrated");
			
			ForkLiftExecutionMetric metrics = new ForkLiftExecutionMetric();
			metrics.setFromDaoName(daoPair.getFrom().getClass().getSimpleName());
			metrics.setToDaoName(daoPair.getTo().getClass().getSimpleName());
			metrics.setFromCount(originalSize);
			metrics.setToCount(dataTo.size());
			metrics.setStartTime(System.currentTimeMillis());
			
			AtomicInteger pending = new AtomicInteger(dataFrom.size());
			metrics.setPending(pending);
			ForkLiftMetricsManager.getIntansce().addExecution(metrics);
			
			dataFrom.forEach( (k,v) ->  {
				daoPair.getTo().insertData(v); 
				pending.decrementAndGet(); 
			});
			
			metrics.setFinishTime(System.currentTimeMillis());
			metrics.setTotalTime( metrics.getFinishTime() -  metrics.getStartTime() );
			metrics.setTotalTimeAsString(TimeUtils.format(metrics.getTotalTime()));
			System.out.println("DONE fork lifiting " + daoPair);
		}
		
	}
	
	private static Map<String,HashComparableRow> getAllDataAsRow(CassDAO dao){
		
		Map<String,HashComparableRow> result = new ConcurrentHashMap<>();
		ResultSet rs = dao.getReadResultSet();
		
		Iterator<Row> iter = rs.iterator();
		while (iter.hasNext()) {
		  Row row = iter.next();
		  result.put( dao.getRowHasher().hash(row), new HashComparableRow(dao.getRowHasher(), row));
		}
		return result;
	}
	
	public synchronized void addDaoPair(DaoPairs daoPair) {
		daos.add(daoPair);
	}
	
	public synchronized void gracefulStop() {
		System.out.println("STOPPING FORKLIFT NOW - BY removing DAOs! ");
		daos = new ConcurrentLinkedQueue<>();
	}
	
}
