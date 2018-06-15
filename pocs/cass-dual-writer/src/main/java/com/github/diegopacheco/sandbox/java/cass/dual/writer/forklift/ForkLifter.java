package com.github.diegopacheco.sandbox.java.cass.dual.writer.forklift;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		 daos.forEach(  d -> forkLift(d)  );
	}
	
	private static void forkLift(DaoPairs daoPair) {
		System.out.println("Forklifiting " + daoPair);
		List<String> data = daoPair.getFrom().getAllData();
		System.out.println(data.size() + " to be MIGRATED");
		
		data.forEach( d ->  daoPair.getTo().insertData(d, d) );
		System.out.println("DONE forklifiting " + daoPair);
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
