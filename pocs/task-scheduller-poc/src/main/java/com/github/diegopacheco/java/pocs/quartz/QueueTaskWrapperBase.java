package com.github.diegopacheco.java.pocs.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public abstract class QueueTaskWrapperBase implements GroupTask {
	
	public void run(JobExecutionContext context) {
		
			Job work = QueueManager.getInstance().giveMeWork(getGroup());
			if (work!=null) {
		
				try {
				
					System.out.println("Running Task: " + work.getClass().getSimpleName());
					work.execute(context);
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally{
					QueueManager.getInstance().releaseWork(getGroup());
				}
				
			}else {
				System.out.println("[" + Thread.currentThread().getName()  +  "] Nothing to do... ");
			}
			
			QuietThread.sleep(1000);
	}
	
}
