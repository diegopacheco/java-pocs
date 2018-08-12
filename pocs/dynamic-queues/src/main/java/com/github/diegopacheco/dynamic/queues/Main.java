package com.github.diegopacheco.dynamic.queues;

import java.util.concurrent.TimeUnit;

import com.github.diegopacheco.dynamic.queues.core.QuietThread;
import com.github.diegopacheco.dynamic.queues.core.SchedullerManager;

public class Main {
	public static void main(String[] args) {
		
		SchedullerManager.getInstance().register("q1");
		SchedullerManager.getInstance().register("q2");
		
		SchedullerManager.getInstance().enqueueTask("q1", new DateTask());
		SchedullerManager.getInstance().enqueueTask("q2", new DateTask());
	  
	  QuietThread.sleep(2000);
		
	  SchedullerManager.getInstance().unregister("q1");
	  SchedullerManager.getInstance().unregister("q2");
	  
	  QuietThread.sleep(2000);
	  SchedullerManager.getInstance().register("q3");
	  SchedullerManager.getInstance().enqueueTask("q3", new DateTask());
	  
	  QuietThread.sleep(2000);
	  SchedullerManager.getInstance().unregister("q3");
	  
	  QuietThread.sleep(2000);
	  SchedullerManager.getInstance().register("q4");
	  SchedullerManager.getInstance().scheduleRecurrent(new DateTask(), "q4", 1, TimeUnit.SECONDS);
	  
	}
}
