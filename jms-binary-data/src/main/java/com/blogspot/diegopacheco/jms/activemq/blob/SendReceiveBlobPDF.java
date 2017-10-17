package com.blogspot.diegopacheco.jms.activemq.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;

import com.blogspot.diegopacheco.jms.broker.EmbedBroker;
import com.blogspot.diegopacheco.jms.util.ByteUtils;

/**
 * 
 * @author Diego Pacheco
 *  
 * ActiveMQ with Blob
 * 
 * -----------------------------------------------------------------------------------------|
 * Optimization                             |					 time (ms)                  |
 * -----------------------------------------------------------------------------------------|
 *  PDF 122mb - NON-PERSISTENT     Message  |   Send    |  Receive    |     Persist/IO      |
 * -----------------------------------------------------------------------------------------|       
 * -Xms128m -Xmx1024m -XX:MaxPermSize=192m  :  5319     |     0       |    15377            |
 * -Xms246m -Xmx1024m -XX:MaxPermSize=256m  :  3162     |     0       |    14926            |
 * -Xms512m -Xmx1024m -XX:MaxPermSize=312m  :  3732     |     0       |    15263            |
 * -----------------------------------------------------------------------------------------| 
 * 
 */
public class SendReceiveBlobPDF {
	
	public static void main(String[] args) {
		
		final String threadName = "[" + args[0] + "]";
		int numMsgToSend;
		if( (args[1]!= null) && (!"".equals(args[1])) ){
			numMsgToSend = Integer.parseInt(args[1]);
		}else{
			numMsgToSend = 1;
		}
		
		//EmbedBroker.start();

		ActiveMQConnection connection = null;
		ActiveMQSession session = null;
		
		final int BUFFER_SIZE = 1048576; // 1 MB	

		try {
			ConnectionFactory cf = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());

			connection = (ActiveMQConnection)  cf.createConnection();
			connection.start();
			
			session = (ActiveMQSession)connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination destination   = session.createQueue("queuePDFBloblarge");
			
			long initTime = System.currentTimeMillis();
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);			

			for(int i=0;i<numMsgToSend;i++){
				String filename = "pdf-119mb.pdf";
				String filepath = (new File(new File(".").getCanonicalPath() + "\\src\\main\\data\\" + filename )).getPath();
				FileInputStream fis = new FileInputStream(new File(filepath));
			
				BlobMessage bm 		= session.createBlobMessage(fis);
				bm.setStringProperty("MIDDLEWARE_STACK_RESULT", new Date().toString());
				
				producer.send(bm);				
				System.out.println(threadName + " +++ Time to SEND[" + (i + 1) + "]: " + ((System.currentTimeMillis()) - initTime) + " ms"  );
			}
			
			
			MessageConsumer comsumer = session.createConsumer(destination);
			comsumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
		
					long recTime = System.currentTimeMillis();
					System.out.println(threadName + " +++ time to RECEIVE: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
					
					if (message instanceof BlobMessage) {
						try {					
							
							recTime = System.currentTimeMillis();
							
							FileOutputStream fos = new FileOutputStream(new File("C:/tmp/pdf-out-file.pdf"));
							
							BlobMessage bm = (BlobMessage)message;
							InputStream is = bm.getInputStream();
							
							ByteUtils.writeOSwithIS(is,fos,BUFFER_SIZE);
							fos.flush();
							fos.close();
							
							System.out.println(threadName + " +++ time to PERSIST/IO: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
							
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
