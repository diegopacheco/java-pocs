package com.github.diegopacheco.dynamic.queues;

import java.util.Date;

import com.github.diegopacheco.dynamic.queues.core.Task;

public class DateTask implements Task {
	@Override
	public void execute() {
		System.out.println("Current Date:" + new Date());
	}
}
