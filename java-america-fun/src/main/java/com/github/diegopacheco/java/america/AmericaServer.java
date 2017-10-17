package com.github.diegopacheco.java.america;

import com.linecorp.armeria.common.SerializationFormat;
import com.linecorp.armeria.common.SessionProtocol;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.thrift.THttpService;
import com.linecorp.armeria.server.docs.DocService;

public class AmericaServer {
	public static void main(String[] args) {
		
		HelloService.AsyncIface helloHandler = new MyHelloService();

		ServerBuilder sb = new ServerBuilder();
		sb.port(8080, SessionProtocol.HTTP);
		sb.serviceAt("/hello",THttpService.of(helloHandler, SerializationFormat.THRIFT_BINARY).decorate(LoggingService::new)).build();
		sb.serviceUnder("/docs/", new DocService());
		
		Server server = sb.build();
		server.start();
		
	}
}
