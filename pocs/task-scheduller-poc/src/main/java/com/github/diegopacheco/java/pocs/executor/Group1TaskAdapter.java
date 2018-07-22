package com.github.diegopacheco.java.pocs.executor;

public class Group1TaskAdapter extends QueueTaskWrapperBase{
	@Override
	public void execute(){
		super.run();
	}
	public String getGroup(){
		return "g1";
	}
}
