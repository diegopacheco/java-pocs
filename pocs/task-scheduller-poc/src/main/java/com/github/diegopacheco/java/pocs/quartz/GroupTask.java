package com.github.diegopacheco.java.pocs.quartz;

import org.quartz.Job;

public interface GroupTask extends Job {
	public String getGroup();
}
