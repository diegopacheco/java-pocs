package com.github.diegopacheco.sandbox.java.cass.dual.writer.forklift;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.datastax.driver.core.Row;
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
					System.out.println("NOTHING to ForkLift. ");
				}else {
					System.out.println("Fork Lifting... " + daos.size() + " daos");
					forkLiftDaos();
				}
			}, 0, 10, TimeUnit.SECONDS);
			
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
		 System.out.println("DONE - Fork Lifting took " + time );
	}
	
	private static void forkLift(DaoPairs daoPair) {
		System.out.println("Forklifiting " + daoPair);
		
		// data should be STREMEAD from cass in order to not load huge datasets to memeory
		// Before inserting forklifter should be more smart an compare hashs to know if that really changed.
		List<Row> dataFrom = daoPair.getFrom().getAllDataAsRow();
		List<Row> dataTo = daoPair.getTo().getAllDataAsRow();
		dataFrom.removeAll(dataTo);
		
		if (dataFrom.size()==0) { 
			System.out.println("All in SYNC");
		}else {
			System.out.println(dataFrom.size() + " to Be Migrated");
			dataFrom.forEach( d ->  daoPair.getTo().insertDataFromRow(d));
			System.out.println("DONE forklifiting " + daoPair);
		}
		
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
