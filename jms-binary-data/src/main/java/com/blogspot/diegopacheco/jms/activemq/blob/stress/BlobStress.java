package com.blogspot.diegopacheco.jms.activemq.blob.stress;

import com.blogspot.diegopacheco.jms.activemq.blob.SendReceiveBlobPDF;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class BlobStress {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		final int THREAD_NUM_STRESS = 1;
		final String MAX_NUM_MSGS_STRESS = "100";
		
		final long initTime = System.currentTimeMillis();		
		for(int i=0;i<=THREAD_NUM_STRESS-1;i++){
			new Thread("Thread" + i){
				public void run() {
					SendReceiveBlobPDF srbp = new SendReceiveBlobPDF();
					srbp.main(new String[]{Thread.currentThread().getName(),MAX_NUM_MSGS_STRESS});
				};
			}.start();		
		}
		
		System.out.println("Execution time for " + THREAD_NUM_STRESS + " thread(s) is " + (System.currentTimeMillis() - initTime) + " ms"  );
	}
}
