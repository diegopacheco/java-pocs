package com.blogspot.diegopacheco.jms.activemq.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;

import com.blogspot.diegopacheco.jms.broker.EmbedBroker;
import com.blogspot.diegopacheco.jms.util.ByteUtils;

/**
 * 
 * @author Diego Pacheco
 *  
 *  ActiveMQ with Streams
 * 
 * -----------------------------------------------------------------------------------------|
 * Optimization                             |					 time (ms)                  |
 * -----------------------------------------------------------------------------------------|
 *  PDF 122mb - NON_PERSISTENT Message      |   Send    |  Receive    |     Persist/IO      |
 * -----------------------------------------------------------------------------------------|       
 * -Xms128m -Xmx1024m -XX:MaxPermSize=192m  :  3525     |   0         |   6413              |
 * -Xms246m -Xmx1024m -XX:MaxPermSize=256m  :  3401     |   0         |   6701              |
 * -Xms512m -Xmx1024m -XX:MaxPermSize=312m  :  3617     |   0         |   5603              |
 * -----------------------------------------------------------------------------------------| 
 * 
 */
public class ActiveMQSendReceiveStreamPDF {
	
	public static void main(String[] args) {
		
		EmbedBroker.start();

		ActiveMQConnection connection = null;
		ActiveMQSession    session    = null;

		try {
			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());
			connection  =  (ActiveMQConnection) cf.createConnection();
			
			connection.start();
			
			session 				  =  (ActiveMQSession)connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination destination   = session.createQueue("queuePDFStreamlarge8");
			
			long initTime = System.currentTimeMillis();
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);			
			
			
			//
			// Send logic
			//
			
			OutputStream os = connection.createOutputStream(destination);			
			
			String filename = "pdf-119mb.pdf";
			String filepath = (new File(new File(".").getCanonicalPath() + "\\src\\main\\data\\" + filename )).getPath();
			
			final int BUFFER_SIZE = 1048576; // 1 MB
			
			ByteUtils.readISWriteOS(new FileInputStream(filepath), os,BUFFER_SIZE);			
			os.close();
			
			System.out.println("+++ Time to SEND: " + ((System.currentTimeMillis()) - initTime) + " ms"  );

			//
			// Receive logic
			//
			
			InputStream messageBackIS = connection.createInputStream(destination);
			
			long recTime = System.currentTimeMillis();
			System.out.println("+++ time to RECEIVE: "    + ((System.currentTimeMillis()) - recTime) + " ms"  );			
			
			recTime = System.currentTimeMillis();
			FileOutputStream fos = new FileOutputStream(new File("C:/tmp/pdf-out-file.pdf"));						
					
			int b = 0;
			byte bArray[] = new byte[BUFFER_SIZE];
			int inc = 0;
			while( ( b = messageBackIS.read()) != -1 ){				
				bArray[inc] = (byte)b;
				if(inc==BUFFER_SIZE-1){
					fos.write( bArray );
					inc = 0;
					bArray = new byte[BUFFER_SIZE];
				}
				inc++;
			}
			fos.write( bArray );
			
			fos.flush();
			fos.close();
			
			messageBackIS.close();
			
			System.out.println("+++ time to PERSIST/IO: " + ((System.currentTimeMillis()) - recTime) + " ms"  );
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		
	}
	
}
