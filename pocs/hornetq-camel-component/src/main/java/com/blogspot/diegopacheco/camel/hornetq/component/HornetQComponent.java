package com.blogspot.diegopacheco.camel.hornetq.component;

import org.apache.camel.component.jms.JmsComponent;

/**
 * 
 * This implementation focus on JBoss HornetQ integration. Developed by:<br>
 * 
 * <b>Diego Pacheco</b><br>
 * <a href='http://diego-pacheco.blogspot.com'>http://diego-pacheco.blogspot.com</a> <br><br>
 * 
 * By default NettyConnectorFactory is the connector default and localhost 
 * and default hornetq port are used, IF useNettyDefaults property have true value.
 *  
 * @author Diego Pacheco
 * @version 1.0
 * @since 21/02/2010
 * 
 * @see org.apache.camel.component.jms.JmsComponent
 * 
 */
public class HornetQComponent extends JmsComponent {
	
	//TODO: Management using hornetq api
	//TODO: create Queues and Topics using the HornetQ Dinamic API
	
	private HornetQCamelConnectionFactory connectionFactory;	
	
	// Setters for Spring Customization
	
	public void setUseNettyDefaults(boolean value){
		if (value==true){
			connectionFactory = new HornetQCamelConnectionFactory();
			connectionFactory.setTransportConfiguration(
				new org.hornetq.api.core.TransportConfiguration("org.hornetq.integration.transports.netty.NettyConnectorFactory")
			);
			super.setConnectionFactory(connectionFactory);
		}		
	}
	
	public void setConnectionFactory(HornetQCamelConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
		super.setConnectionFactory(connectionFactory);
	}	
	
}
