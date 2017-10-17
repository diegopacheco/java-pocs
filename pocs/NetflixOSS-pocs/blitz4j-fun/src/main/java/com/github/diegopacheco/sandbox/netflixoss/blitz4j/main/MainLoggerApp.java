package com.github.diegopacheco.sandbox.netflixoss.blitz4j.main;

import java.util.Properties;

import org.slf4j.LoggerFactory;

import com.netflix.blitz4j.LoggingConfiguration;

public class MainLoggerApp {
	public static void main(String[] args) {

		Properties props = new Properties();
		props.setProperty("log4j.rootCategory", "OFF");
        props.setProperty("log4j.logger.com.github.diegopacheco.sandbox.netflixoss.blitz4j.main.MainLoggerApp","INFO, stdout");
        props.setProperty("log4j.logger.com.github.diegopacheco.sandbox.netflixoss.blitz4j.main.MainLoggerApp$1","INFO,stdout");
        props.setProperty("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");
        props.setProperty("log4j.appender.stdout.layout","com.netflix.logging.log4jAdapter.NFPatternLayout");
        props.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d %-5p %C:%L [%t] [%M] %m%n");
        props.setProperty("log4j.logger.asyncAppenders", "INFO,stdout");
        props.setProperty("batcher.com.netflix.logging.AsyncAppender.stdout.waitTimeinMillis","120000");
        LoggingConfiguration.getInstance().configure(props);

        org.slf4j.Logger slfLogger = LoggerFactory.getLogger(MainLoggerApp.class);
        slfLogger.info("Testing named log with this string {}", "Test String");
		
        LoggingConfiguration.getInstance().stop();
	}
}
