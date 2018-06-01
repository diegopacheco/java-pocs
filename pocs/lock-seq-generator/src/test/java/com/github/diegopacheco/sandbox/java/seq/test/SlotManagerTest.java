package com.github.diegopacheco.sandbox.java.seq.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.github.diegopacheco.sandbox.java.seq.SlotManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SlotManagerTest {
	
	private final Queue<Integer> seqs_3 = new ConcurrentLinkedQueue<>();
	private final Queue<Integer> seqs_4 = new ConcurrentLinkedQueue<>();
	private final Queue<Integer> seqs_5 = new ConcurrentLinkedQueue<>();
	
	@Test
	public void a_1_SimpleNextSlotShouldBe5() {
		SlotManager.getInstance().registerCluster("cluster1", 5);
		SlotManager.getInstance().nextSlot("cluster1");
		SlotManager.getInstance().nextSlot("cluster1");
		SlotManager.getInstance().nextSlot("cluster1");
		SlotManager.getInstance().nextSlot("cluster1");
		int next = SlotManager.getInstance().nextSlot("cluster1");
		assertTrue(4 == next);
	}

	@Test
	public void a_2_SimpleNextSlot() {
		SlotManager.getInstance().registerCluster("cluster2", 1);
		int next = SlotManager.getInstance().nextSlot("cluster2");
		assertTrue(0 == next);
	}
	
	private void quitSleep(int t) {
		try {
			Thread.sleep(t);
		}catch(Exception e) {}
	}
	
	private Runnable createRunnable(final String cluster,Queue<Integer> seqs) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					int next = SlotManager.getInstance().nextSlot(cluster);
					System.out.println(Thread.currentThread().getName() + " Got: " + next);
					seqs.add(next);
				}catch(Exception e) {
					System.out.println(Thread.currentThread().getName()  + " -> " + e.getMessage());
				}
			}
		};
	}
	
	@Test
	public void a_3_ComplexNextSlot() {
		
		SlotManager.getInstance().registerCluster("cluster3", 9);
		
		ExecutorService es = Executors.newFixedThreadPool(8);
		for(int i=0; i<=7; i++)
			es.submit(createRunnable("cluster3",seqs_3));
		es.shutdown();
		quitSleep(500);
		
		int next = SlotManager.getInstance().nextSlot("cluster3");
		assertSame(8, next);
		assertTrue(seqs_3.size()==8);
	}
	
	@Test
	public void a_4_ComplexNextSlot_ViolateMaxSlots() {
		
		SlotManager.getInstance().registerCluster("cluster4", 4);
		
		ExecutorService es = Executors.newFixedThreadPool(8);
		for(int i=0; i<=7; i++)
			es.submit(createRunnable("cluster4",seqs_4));
		es.shutdown();
		
		assertTrue(seqs_4.size()==4);
	}
	
	@Test
	public void a_5_ComplexNextSlot_Return() {
		
		SlotManager.getInstance().registerCluster("cluster5", 4);
		
		ExecutorService es = Executors.newFixedThreadPool(8);
		for(int i=0; i<=3; i++)
			es.submit(createRunnable("cluster5",seqs_5));
		es.shutdown();
		quitSleep(1000);
		
		assertSame(seqs_5.size(), 4);
		
		SlotManager.getInstance().returnSlot("cluster5", 2);
		SlotManager.getInstance().returnSlot("cluster5", 3);
		
		es = Executors.newFixedThreadPool(2);
		for(int i=0; i<=1; i++)
			es.submit(createRunnable("cluster5",seqs_5));
		es.shutdown();
		quitSleep(1000);
		assertTrue(seqs_5.size()==6);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void a_6_expectExceptionClusterNotRegistered() {
		SlotManager.getInstance().nextSlot("clusterThatIsNotRegisterer1");
	}
	
	@Test(expected=RuntimeException.class)
	public void a_7_expectExceptionReturnClusterNotRegistered() {
		SlotManager.getInstance().returnSlot("clusterThatIsNotRegisterer1",10);
	}

}
