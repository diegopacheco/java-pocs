package com.github.diegopacheco.sandbox.java.esper.fun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;

public class EsperMainStdLasevent {
	public static void main(String[] args) {

		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

		Map<String, Object> updatedFieldDef = new HashMap<String, Object>();
		updatedFieldDef.put("status", String.class);
		updatedFieldDef.put("timestamp", String.class);
		epService.getEPAdministrator().getConfiguration().addEventType("StatusEvent", updatedFieldDef);

		epService.getEPAdministrator().createEPL(
				"create window StatusEventWindow.std:lastevent() as select status,timestamp from StatusEvent");
		epService.getEPAdministrator().createEPL(
				"insert into StatusEventWindow(status, timestamp) select status, timestamp from com.github.diegopacheco.sandbox.java.esper.fun.StatusEvent.std:lastevent()");
		EPStatement statement = epService.getEPAdministrator().createEPL("select * from StatusEventWindow", "exp1");

		UpdateListener listener = new ConsoleListener();
		statement.addListener(listener);

		for (String name : epService.getEPAdministrator().getStatementNames()) {
			System.out.println("Stmt on Esper: " + name + " Status: "
					+ epService.getEPAdministrator().getStatement(name).getState() + " Text: "
					+ epService.getEPAdministrator().getStatement(name).getText());

		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					StatusEvent event = new StatusEvent("DOWN", getCurrentTimeStamp());
					epService.getEPRuntime().sendEvent(event);
					sleep(2000L);
				}
			}
		}).start();

		sleep(3000L);
		epService.getEPAdministrator().getStatement("exp1").destroy();
		statement = epService.getEPAdministrator().createEPL("select * from StatusEventWindow", "exp1");
		statement.addListener(listener);

		statement = epService.getEPAdministrator().createEPL("select * from StatusEventWindow", "exp2");
		statement.addListener(listener);

		statement = epService.getEPAdministrator().createEPL("select * from StatusEventWindow", "exp3");
		statement.addListener(listener);

	}

	public static String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

	public static void sleep(Long timeInMs) {
		try {
			Thread.sleep(timeInMs);
		} catch (InterruptedException e) {
		}
	}
}
