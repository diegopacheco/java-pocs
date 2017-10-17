package com.blogspot.diegopacheco.cxf.prog;

import javax.xml.ws.Endpoint;

public class WSExporterCGLib {

	public void export() {
		System.out.println("Publishing WS by code... ");

		DateService implementor = (DateService) BaseCGLibEnhacer.newInstance(DateService.class);

		Endpoint.publish("/ds", implementor);

		System.out.println("WS Publishing done! ");

	}

}
