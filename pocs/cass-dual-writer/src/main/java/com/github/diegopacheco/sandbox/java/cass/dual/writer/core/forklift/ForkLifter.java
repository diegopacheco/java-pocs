package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.CassDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.HashComparableRow;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass2xDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass3xDAO;

public class ForkLifter {
	
	private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	private static ForkLifter instance;
	private static List<DaoPairs> daos = new ArrayList<>();
	
	private ForkLifter() {}
	
	public static synchronized ForkLifter getInstance() {
		if (instance==null) {
			instance = new ForkLifter();
			
			executor.scheduleAtFixedRate( () -> {
				if (daos==null || daos.size()==0){
					System.out.println("NO DAOs to ForkLift. ");
				}else {
					System.out.println("Fork Lifting... " + daos.size() + " daos");
					forkLiftDaos();
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
		 String time = String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(millis),
			    TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
			);
		 System.out.println("DONE Fork Lifting took " + time + " \n");
	}
	
	private static void forkLift(DaoPairs daoPair) {
		System.out.println("Forklifiting " + daoPair);
		
		Map<String,HashComparableRow> dataFrom = getAllDataAsRow(daoPair.getFrom());
		Map<String,HashComparableRow> dataTo = getAllDataAsRow(daoPair.getTo());
		
		for(String key : dataFrom.keySet()) {
			 if (dataTo.get(key)!=null)
				 dataFrom.remove(key);
		}
		
		if (dataFrom.size()==0) { 
			System.out.println("All in SYNC - Nothing to do!");
		}else {
			System.out.println(dataFrom.size() + " ROW to Be Migrated");
			dataFrom.forEach( (k,v) ->  daoPair.getTo().insertData(v));
			System.out.println("DONE fork lifiting " + daoPair);
		}
		
	}
	
	private static Map<String,HashComparableRow> getAllDataAsRow(CassDAO dao){
		
		Map<String,HashComparableRow> result = new HashMap<>();
		ResultSet rs = dao.getReadResultSet();
		
		Iterator<Row> iter = rs.iterator();
		while (iter.hasNext()) {
		  Row row = iter.next();
		  result.put( dao.getRowHasher().hash(row), new HashComparableRow(dao.getRowHasher(), row));
		}
		return result;
	}
	
	public void addDaoPair(DaoPairs daoPair) {
		daos.add(daoPair);
	}
	
	public static void main(String[] args) {
		ForkLifter fl = ForkLifter.getInstance();
		System.out.println(fl);
		fl.addDaoPair(new DaoPairs(new Cass2xDAO(), new Cass3xDAO()));
	}
	
}
