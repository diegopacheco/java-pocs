package com.github.diegopacheco.java.pocs.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Group2TaskAdapter extends QueueTaskWrapperBase{
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		super.run(context);
	}
	public String getGroup(){
		return "g2";
	}
}
