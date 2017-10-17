package com.github.diegopacheco.sandbox.java.esper.fun;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ConsoleListener implements UpdateListener {
    
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        EventBean event = newEvents[0];
        System.out.println("Event Status:" + get("status",event) + " - timestamp: " + get("timestamp",event) );
    }
    
    private String get(String field, EventBean event){
    	try{
    		return event.get(field).toString();
    	}catch(Exception e){
    		return "ERROR: " + e.getMessage();
    	}
    }
}