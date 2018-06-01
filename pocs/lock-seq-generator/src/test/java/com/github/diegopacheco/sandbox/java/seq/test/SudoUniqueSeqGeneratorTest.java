package com.github.diegopacheco.sandbox.java.seq.test;

import static org.junit.Assert.assertTrue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.github.diegopacheco.sandbox.java.seq.SudoUniqueSeqGenerator;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SudoUniqueSeqGeneratorTest {
	
	private final Queue<Integer> seqs_3 = new ConcurrentLinkedQueue<>();
	private final Queue<Integer> seqs_4 = new ConcurrentLinkedQueue<>();
	
	@Test
	public void a_1_SimpleNextSlotShouldBe5() {
		SudoUniqueSeqGenerator.getInstance().registerCluster("cluster1", 5);
		SudoUniqueSeqGenerator.getInstance().nextSlot("cluster1");
		SudoUniqueSeqGenerator.getInstance().nextSlot("cluster1");
		SudoUniqueSeqGenerator.getInstance().nextSlot("cluster1");
		SudoUniqueSeqGenerator.getInstance().nextSlot("cluster1");
		int next = SudoUniqueSeqGenerator.getInstance().nextSlot("cluster1");
		assertTrue(4 == next);
	}

	@Test
	public void a_2_SimpleNextSlot() {
		SudoUniqueSeqGenerator.getInstance().registerCluster("cluster2", 1);
		int next = SudoUniqueSeqGenerator.getInstance().nextSlot("cluster2");
		assertTrue(0 == next);
	}
	
	private Runnable createRunnable(final String cluster,Queue<Integer> seqs) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					int next = SudoUniqueSeqGenerator.getInstance().nextSlot(cluster);
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
		
		SudoUniqueSeqGenerator.getInstance().registerCluster("cluster3", 10);
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i<=9; i++)
			es.submit(createRunnable("cluster3",seqs_3));
		es.shutdown();
		
		int next = SudoUniqueSeqGenerator.getInstance().nextSlot("cluster3");
		assertTrue(10 == next);
		assertTrue(seqs_3.size()==10);
	}
	
	@Test
	public void a_4_ComplexNextSlot_ViolateMaxSlots() {
		
		SudoUniqueSeqGenerator.getInstance().registerCluster("cluster4", 5);
		
		ExecutorService es = Executors.newFixedThreadPool(7);
		for(int i=0; i<=7; i++)
			es.submit(createRunnable("cluster4",seqs_4));
		es.shutdown();
		
		assertTrue(seqs_4.size()==5);
	}

}
