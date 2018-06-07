package com.github.diegopacheco.sandbox.java.process;

/**
 * Home for utility pre-build checkers.
 * 
 * @author diegopacheco
 *
 */
public class ProcessCheckers {
	
	public static ProcessChecker NO_CHECKER = new ProcessChecker() {
		@Override
		public boolean isDoingProgress(PIDMetadata pim) {
			return true;
		}
		@Override
		public boolean hasCompleted(PIDMetadata pim) {
			return true;
		}
		@Override
		public String toString() {
			return "NO_CHECKER";
		}
	};
	
}
