package com.blogspot.diegopacheco.jms.broker;

import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.util.LoggingBrokerPlugin;
import org.apache.activemq.broker.util.TimeStampingBrokerPlugin;
import org.apache.activemq.store.kahadaptor.KahaPersistenceAdapter;

/**
 * 
 * @author Diego Pacheco
 * 
 */
public class EmbedBroker {
	
	private static BrokerService broker; 
	
	public static String getBrokerURL(){
	   return "tcp://localhost:61616?jms.blobTransferPolicy.uploadUrl=http://localhost:8161/fileserver/";
	}
	
	public static void start(){		
		broker = new BrokerService();
		try {
			broker.setUseJmx(true);
			broker.setBrokerName("pachecoMessageBroker");
			
			broker.addConnector(getBrokerURL());			
			broker.setPersistenceAdapter(new KahaPersistenceAdapter());			
			
			broker.setPlugins(new BrokerPlugin[]{
												new LoggingBrokerPlugin(),
												new TimeStampingBrokerPlugin(),
											}
							  );
			
			broker.start();
			System.out.println("Broker started fine, ready to use!");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
