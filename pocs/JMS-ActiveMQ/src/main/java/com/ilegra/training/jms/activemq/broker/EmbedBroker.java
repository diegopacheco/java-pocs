package com.ilegra.training.jms.activemq.broker;

import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.util.LoggingBrokerPlugin;
import org.apache.activemq.broker.util.TimeStampingBrokerPlugin;
import org.apache.activemq.broker.view.DestinationDotFilePlugin;
import org.apache.activemq.store.kahadaptor.KahaPersistenceAdapter;

/**
 * ActiveMQ Embed Broker sample code
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 03/29/2010
 * 
 */
public class EmbedBroker {
	
	private static BrokerService broker; 
	
	public static String getBrokerURL(){
	   return "tcp://localhost:61616";
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
												new DestinationDotFilePlugin()
											}
							  );
			
			broker.start();
			System.out.println("Broker started fine, redy to use!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
