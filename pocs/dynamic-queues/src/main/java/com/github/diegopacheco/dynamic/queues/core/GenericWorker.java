package com.github.diegopacheco.dynamic.queues.core;

import java.util.concurrent.Callable;

class GenericWorker implements GroupTask, Callable<Void>{

	private String name; 
	private String group;
	
	public GenericWorker(String group,String name) {
		super();
		if(group==null || "".equals(group))
			throw new IllegalArgumentException("Group cannot be null nor empty");
		this.group = group;
		this.name = name;
	}

	@Override
	public Void call() throws Exception {
		execute();
		return null;
	}
	
	@Override
	public void execute() {
		 Task work = QueueManager.getInstance().giveMeWork(getGroup());
			if (work!=null) {
		
				try {
				
					System.out.println("[" + getName() + "] Running Task: " + work.getClass().getSimpleName() + " from group: " + getGroup());
					work.execute();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally{
					QueueManager.getInstance().releaseWork(getGroup());
				}
				
			}else {
				System.out.println("[" + getName() + "] - [" + Thread.currentThread().getName()  +  "] Nothing to do... ");
			}
			
			QuietThread.sleep(1000);
	}
	
	public String getGroup(){
		return group;
	}
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericWorker other = (GenericWorker) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}
	
}
