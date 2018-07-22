package com.github.diegopacheco.java.pocs.executor;

public abstract class QueueTaskWrapperBase implements GroupTask {
	
	public void run() {
		
		 Task work = QueueManager.getInstance().giveMeWork(getGroup());
			if (work!=null) {
		
				try {
				
					System.out.println("Running Task: " + work.getClass().getSimpleName() + " from group: " + getGroup());
					work.execute();
					
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
