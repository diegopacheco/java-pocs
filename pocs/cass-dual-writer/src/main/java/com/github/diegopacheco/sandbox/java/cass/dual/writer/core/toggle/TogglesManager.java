package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle.TogglesProps.SourceOfTruth;

public class TogglesManager {
	
	private static TogglesManager instance;
	private static Map<String, Object> toggles = new ConcurrentHashMap<>();
	
	private TogglesManager() {}
	
	public synchronized static TogglesManager getInstance() {
		if (instance==null) {
			instance = new TogglesManager();
			toggles.put(TogglesProps.DUAL_WRITE_PROP, false);
			toggles.put(TogglesProps.SOURCE_OF_TRUTH_PROP, SourceOfTruth.CASS2x);
			toggles.put(TogglesProps.FORKLIFT_PROP, false);
		}
		return instance;
	}
	
	public boolean isDualWrtiteEnable() {
		return (boolean)toggles.get(TogglesProps.DUAL_WRITE_PROP);
	}
	
	public boolean switchDualWrite() {
		toggles.put(TogglesProps.DUAL_WRITE_PROP, !(boolean)toggles.get(TogglesProps.DUAL_WRITE_PROP));
		return (boolean)toggles.get(TogglesProps.DUAL_WRITE_PROP);
	}
	
	public void setSourceOfTruth(SourceOfTruth sot) {
		toggles.put(TogglesProps.SOURCE_OF_TRUTH_PROP, sot);
	}
	
	public SourceOfTruth getSourceOfTruth() {
		return (SourceOfTruth)toggles.get(TogglesProps.SOURCE_OF_TRUTH_PROP);
	}
	
	public boolean isForkLift() {
		return (boolean)toggles.get(TogglesProps.FORKLIFT_PROP);
	}
	
	public boolean switchForkLift() {
		toggles.put(TogglesProps.FORKLIFT_PROP, !(boolean)toggles.get(TogglesProps.FORKLIFT_PROP));
		return (boolean)toggles.get(TogglesProps.FORKLIFT_PROP);
	}
	
}
