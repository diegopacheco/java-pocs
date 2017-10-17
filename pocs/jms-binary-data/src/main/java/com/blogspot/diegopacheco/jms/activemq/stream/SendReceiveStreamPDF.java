package com.blogspot.diegopacheco.jms.activemq.stream;

import java.io.File;
import java.io.FileOutputStream;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.StreamMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.blogspot.diegopacheco.jms.broker.EmbedBroker;
import com.blogspot.diegopacheco.jms.util.ByteUtils;

/**
 * 
 * @author Diego Pacheco
 *  
 *  JMS with Streams
 * 
 * -----------------------------------------------------------------------------------------|
 * Optimization                             |					 time (ms)                  |
 * -----------------------------------------------------------------------------------------|
 *  PDF 122mb - PERSISTENT     Message      |   Send    |  Receive    |     Persist/IO      |
 * -----------------------------------------------------------------------------------------|       
 * -Xms128m -Xmx1024m -XX:MaxPermSize=192m  :  8912     |  699        |     4024            |
 * -Xms246m -Xmx1024m -XX:MaxPermSize=256m  :  9549     |  712        |     4689            |
 * -Xms512m -Xmx1024m -XX:MaxPermSize=312m  :  8804     |  709        |     4526            |
 * -----------------------------------------------------------------------------------------| 
 * 
 */
public class SendReceiveStreamPDF {
	
	public static void main(String[] args) {
		
		EmbedBroker.start();

		Connection connection = null;
		Session session = null;

		try {
			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());
			connection 					 = cf.createConnection();
			
			connection.start();
			
			session 				  =  connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination destination   = session.createQueue("queuePDFStreamlarge2");
			
			long initTime = System.currentTimeMillis();
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);			
			
			StreamMessage sm  = session.createStreamMessage();
		
			String filename = "pdf-119mb.pdf";
			
			byte buffer[] = ByteUtils.loadFile( (new File(new File(".").getCanonicalPath() + "\\src\\main\\data\\" + filename )).getPath() );
			sm.writeBytes(buffer);
			sm.setIntProperty("size",buffer.length);
			
			producer.send(sm);
			
			System.out.println("+++ Time to SEND: " + ((System.currentTimeMillis()) - initTime) + " ms"  );

			MessageConsumer comsumer = session.createConsumer(destination);
			comsumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
		
					long recTime = System.currentTimeMillis();					
					if (message instanceof StreamMessage) {
						try {

							FileOutputStream fos = new FileOutputStream(new File("C:/tmp/pdf-out-file.pdf"));
							
							int size = message.getIntProperty("size");
							byte[] replyBytes = new byte[size];
							
							System.out.println("+++ time to RECEIVE: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
							recTime = System.currentTimeMillis();
							
							((StreamMessage)message).readBytes(replyBytes);
							
							fos.write( replyBytes );
							fos.flush();
							fos.close();
							
							System.out.println("+++ time to PERSIST/IO: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		
	}
	
}
