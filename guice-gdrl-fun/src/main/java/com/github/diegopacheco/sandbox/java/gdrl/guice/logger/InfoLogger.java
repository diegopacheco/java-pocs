package com.github.diegopacheco.sandbox.java.gdrl.guice.logger;

import javax.inject.Singleton;
import org.slf4j.Logger;

@Singleton
public class InfoLogger {
	
	@Log Logger logger;
	
	public void info(String msg) {
		logger.info("[LOGGING] " + msg);
	}
	
}
