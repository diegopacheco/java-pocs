package com.blogspot.diegopacheco.jms.activemq.binary;

import java.io.File;
import java.io.FileOutputStream;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.blogspot.diegopacheco.jms.broker.EmbedBroker;
import com.blogspot.diegopacheco.jms.util.ByteUtils;

/**
 * 
 * @author Diego Pacheco
 *  
 * JMS with Binary
 * 
 * -----------------------------------------------------------------------------------------|
 * Optimization                             |					 time (ms)                  |
 * -----------------------------------------------------------------------------------------|
 *  PDF 122mb - PERSISTENT     Message      |   Send    |  Receive    |     Persist/IO      |
 * -----------------------------------------------------------------------------------------|       
 * -Xms128m -Xmx1024m -XX:MaxPermSize=192m  :  9800     |  749        |    5153             |
 * -Xms246m -Xmx1024m -XX:MaxPermSize=256m  :  8381     |  736        |    5294             |
 * -Xms512m -Xmx1024m -XX:MaxPermSize=312m  :  10344    |  722        |    3954             |
 * -----------------------------------------------------------------------------------------| 
 * 
 */
public class SendReceiveBinaryPDF {
	
	public static void main(String[] args) {
		
		EmbedBroker.start();

		Connection connection = null;
		Session session = null;

		try {
			ConnectionFactory cf = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());

			connection =  cf.createConnection();
			connection.start();
			session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination destination   = session.createQueue("queuePDFBinarylarge");
			
			long initTime = System.currentTimeMillis();
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);			
			
			BytesMessage bm 		 = session.createBytesMessage();
		
			String filename = "pdf-119mb.pdf";
			
			byte buffer[] = ByteUtils.loadFile( (new File(new File(".").getCanonicalPath() + "\\src\\main\\data\\" + filename )).getPath() );
			bm.writeBytes(buffer);
			bm.setIntProperty("size",buffer.length);
			
			producer.send(bm);
			
			System.out.println("+++ Time to SEND: " + ((System.currentTimeMillis()) - initTime) + " ms"  );

			MessageConsumer comsumer = session.createConsumer(destination);
			comsumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
		
					System.out.println("Message here");
					long recTime = System.currentTimeMillis();
					
					if (message instanceof BytesMessage) {
						try {
							System.out.println("Bytes: " + message);
							
							FileOutputStream fos = new FileOutputStream(new File("C:/tmp/pdf-out-file.pdf"));
							
							int size = message.getIntProperty("size");
							byte[] replyBytes = new byte[size];
							
							System.out.println("+++ time to RECEIVE: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
							recTime = System.currentTimeMillis();
							
							((BytesMessage)message).readBytes(replyBytes);
							
							fos.write( replyBytes );
							fos.flush();
							fos.close();
							
							System.out.println("+++ time to PERSIST/IO: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
							System.out.println("File saved in fs. ");
							
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
