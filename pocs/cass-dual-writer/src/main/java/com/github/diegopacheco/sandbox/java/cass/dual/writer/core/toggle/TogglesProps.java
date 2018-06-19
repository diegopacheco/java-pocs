package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle;

public class TogglesProps {
	
	public static final String DUAL_WRITE_PROP      = "dual.write";
	public static final String SOURCE_OF_TRUTH_PROP = "source.of.truth";
	
	public static enum SourceOfTruth{
		CASS2x, CASS3x
	};
	
}
