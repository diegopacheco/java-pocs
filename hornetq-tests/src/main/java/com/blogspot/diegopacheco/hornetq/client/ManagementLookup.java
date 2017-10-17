package com.blogspot.diegopacheco.hornetq.client;

import javax.jms.Session;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.core.client.ClientMessage;
import org.hornetq.api.core.client.ClientRequestor;
import org.hornetq.api.core.client.ClientSession;
import org.hornetq.api.core.management.ManagementHelper;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.integration.transports.netty.NettyConnectorFactory;
import org.hornetq.jms.client.HornetQConnection;
import org.hornetq.jms.client.HornetQConnectionFactory;
import org.hornetq.jms.client.HornetQSession;

/**
 * 
 * Não consegui fazer funcionar ainda.
 * 
 * @author Diego Pacheco
 *
 */
public class ManagementLookup {
	public static void main(String[] args) throws Throwable {

		TransportConfiguration transportConfiguration = new TransportConfiguration(	NettyConnectorFactory.class.getName());
		
		HornetQConnectionFactory hcf  = null;
		HornetQConnection hc = null;
		HornetQSession hs	 = null;		

		try {

			hcf =  (HornetQConnectionFactory)HornetQJMSClient.createConnectionFactory(transportConfiguration);
			hc  =  (HornetQConnection)hcf.createConnection();
			hc.setClientID("javaClientBR");
			
			hs  =  (HornetQSession)hc.createSession(false, Session.AUTO_ACKNOWLEDGE);
						
			ClientSession cs = hs.getCoreSession();			
			
			ClientRequestor requestor = new ClientRequestor(cs,"jms.queue.hornetq.management");
			ClientMessage message     = cs.createMessage(false);
			
			ManagementHelper.putAttribute(message,"filaDeTestes","messageCount");
			ClientMessage reply = requestor.request(message);
			
			int count=(Integer)ManagementHelper.getResult(reply);
			System.out.println("There are " + count + "messages in Queue");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (hs != null) hs.close();
			if (hc != null) hc.close();
		}

	}
}
