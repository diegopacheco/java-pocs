package org.apache.camel.example.server;

import org.apache.camel.example.reportincident.InputReportIncident;
import org.apache.camel.example.reportincident.OutputReportIncident;

public class IncidentBean {

    public OutputReportIncident reportIncident(InputReportIncident in) {
    	
    	System.out.println("Recived: " + in);
    	
        OutputReportIncident out = new OutputReportIncident();
        out.setCode(in.getIncidentId() + " = OK");
        return out;
    }

}