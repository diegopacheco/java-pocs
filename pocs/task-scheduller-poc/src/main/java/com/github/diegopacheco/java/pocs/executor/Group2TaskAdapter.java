package com.github.diegopacheco.java.pocs.executor;

public class Group2TaskAdapter extends QueueTaskWrapperBase{
	@Override
	public void execute(){
		super.run();
	}
	public String getGroup(){
		return "g2";
	}
}
