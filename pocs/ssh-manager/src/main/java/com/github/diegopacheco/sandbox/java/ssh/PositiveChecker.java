package com.github.diegopacheco.sandbox.java.ssh;

/**
 * PositiveChecker should be used just for test - assume task run in 1s and there is no errors.
 * 
 * @author diegopacheco
 *
 */
public class PositiveChecker implements PIDChecker{
	
	@Override
	public boolean hasCompleted() {
		return true;
	}

	@Override
	public boolean isDoingProgress() {
		return true;
	}

}
