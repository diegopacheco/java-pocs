package com.blogspot.diegopacheco.camel.hornetq.component;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.jms.client.HornetQConnection;
import org.hornetq.jms.client.HornetQConnectionFactory;

/**
 * A ConnectionFactory is an an Administered object, and is used for creating
 * Connections. <br><br>
 * 
 * This class also implements QueueConnectionFactory and TopicConnectionFactory.
 * You can use this connection to create both QueueConnections and
 * TopicConnections. <br>
 * 
 * This implementation focus on JBoss HornetQ integration. Developed by:<br>
 * 
 * <b>Diego Pacheco</b><br>
 * <a href='http://diego-pacheco.blogspot.com'>http://diego-pacheco.blogspot.com</a>
 *  
 * @author Diego Pacheco
 * @version 1.0
 * @since 21/02/2010
 * 
 * @see javax.jms.ConnectionFactory
 * @see javax.jms.QueueConnectionFactory
 * @see javax.jms.TopicConnectionFactory
 * @see java.lang.Cloneable
 * 
 */
public class HornetQCamelConnectionFactory implements ConnectionFactory, QueueConnectionFactory, TopicConnectionFactory, Cloneable {
	
	private TransportConfiguration transportConfiguration;
	private HornetQConnectionFactory connectionFactory; 		
	private HornetQConnection connection; 
	
	private String clientID;
	
	
	@Override
	public Connection createConnection() throws JMSException {
		return createHornetQConnectionByUserAndPass(null,null);
	}

	@Override
	public Connection createConnection(String userName, String password) throws JMSException {
		return createHornetQConnectionByUserAndPass(userName,password);
	}

	@Override
	public QueueConnection createQueueConnection() throws JMSException {
		return createHornetQConnectionByUserAndPass(null,null);
	}

	@Override
	public QueueConnection createQueueConnection(String userName,String password) throws JMSException {
		return createHornetQConnectionByUserAndPass(userName,password);
	}

	@Override
	public TopicConnection createTopicConnection() throws JMSException {
		return createHornetQConnectionByUserAndPass(null,null);
	}

	@Override
	public TopicConnection createTopicConnection(String userName,String password) throws JMSException {
		return createHornetQConnectionByUserAndPass(null,null);
	}
	
	private synchronized HornetQConnectionFactory createHornetQConnectionFactory(){		
		if (connectionFactory==null)		
			connectionFactory = (HornetQConnectionFactory) HornetQJMSClient.createConnectionFactory(transportConfiguration);
		return connectionFactory; 
	}
	
	private synchronized HornetQConnection createHornetQConnection() throws JMSException{

		//TODO: avoid create connection every message
		//TODO: avoid worng clean up of resources
		
		//if (connection==null)
			connection = (HornetQConnection) createHornetQConnectionFactory().createConnection();
		return connection; 
	}	
	
    protected HornetQConnection createHornetQConnectionByUserAndPass(String userName, String password) throws JMSException {
    	
       try {
            
    	    createHornetQConnectionFactory();
    	    createHornetQConnection();
    	   
            //TODO: Apply connections properties and specific HornetQ configs    	    
    	    //TODO: Pass user and passeword to hornetq connection

            if ((clientID!=null) && (!"".equals(clientID)) ) {
                connection.setClientID(clientID);
            }

            return connection;
            
        } catch (JMSException e) {            
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
            throw e;
        } catch (Exception e) {
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
            throw new JMSException(e.getMessage());
        }
    }
    
    
    // Setters for spring configuration customization
    
	public void setTransportConfiguration(TransportConfiguration transportConfiguration) {
		this.transportConfiguration = transportConfiguration;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
    
    
}
