package com.github.diegopacheco.sandbox.java.esper.fun;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;

public class EsperMain {
	
	public static void main(String[] args) {

		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
		
		String expression = "select status,timestamp from com.github.diegopacheco.sandbox.java.esper.fun.StatusEvent.win:time(30 sec)";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression,"exp1");
		
		UpdateListener listener = new ConsoleListener();
		statement.addListener(listener);
		
		for (String name : epService.getEPAdministrator().getStatementNames()){
			System.out.println("Stmt on Esper: " + name + " Status: " + 
				epService.getEPAdministrator().getStatement(name).getState() + " Text: " +
				epService.getEPAdministrator().getStatement(name).getText()
			);
			
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					StatusEvent event = new StatusEvent("DOWN", getCurrentTimeStamp());
					epService.getEPRuntime().sendEvent(event);
					sleep(2000L);
				}
			}
		}).start();
		
		sleep(3000L);
		epService.getEPAdministrator().getStatement("exp1").destroy();
		statement = epService.getEPAdministrator().createEPL("select status from com.github.diegopacheco.sandbox.java.esper.fun.StatusEvent.win:time(30 sec)","exp1");
		statement.addListener(listener);
		
		statement = epService.getEPAdministrator().createEPL("select status,timestamp from com.github.diegopacheco.sandbox.java.esper.fun.StatusEvent.win:time(30 sec)","exp2");
		statement.addListener(listener);
		
		statement = epService.getEPAdministrator().createEPL("select status,timestamp from com.github.diegopacheco.sandbox.java.esper.fun.StatusEvent.win:time(30 sec)","exp3");
		statement.addListener(listener);
		
	}
	
	public static String getCurrentTimeStamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	
	public static void sleep(Long timeInMs){
		try {
			Thread.sleep(timeInMs);
		} catch (InterruptedException e) {}
	}
	
}
