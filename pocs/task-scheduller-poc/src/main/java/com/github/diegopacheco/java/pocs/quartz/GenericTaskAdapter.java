package com.github.diegopacheco.java.pocs.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GenericTaskAdapter extends QueueTaskWrapperBase{
	
	private JobExecutionContext context;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		this.context = context;
		super.run(context);
	}
	
	public String getGroup(){
		String group = context.getJobDetail().getKey().getGroup();
		if(group==null || "".equals(group))
			throw new IllegalArgumentException("Group cannot be null nor empty");
		return group;
	}
}
