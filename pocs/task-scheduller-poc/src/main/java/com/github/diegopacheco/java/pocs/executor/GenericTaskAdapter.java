package com.github.diegopacheco.java.pocs.executor;

public class GenericTaskAdapter extends QueueTaskWrapperBase{
	
	private String group;
	
	public GenericTaskAdapter(String group) {
		super();
		if(group==null || "".equals(group))
			throw new IllegalArgumentException("Group cannot be null nor empty");
		this.group = group;
	}

	@Override
	public void execute(){
		super.run();
	}
	
	public String getGroup(){
		return group;
	}
}
