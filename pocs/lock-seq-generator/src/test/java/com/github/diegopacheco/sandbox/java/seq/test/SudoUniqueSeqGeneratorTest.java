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
	
	private final Queue<Integer> seqs = new ConcurrentLinkedQueue<>();
	
	@Test
	public void a_1_SimpleNextSlotShouldBe5() {
		SudoUniqueSeqGenerator.getInstance().nextSlot();
		SudoUniqueSeqGenerator.getInstance().nextSlot();
		SudoUniqueSeqGenerator.getInstance().nextSlot();
		SudoUniqueSeqGenerator.getInstance().nextSlot();
		int next = SudoUniqueSeqGenerator.getInstance().nextSlot();
		assertTrue(4 == next);
	}

	@Test
	public void a_2_SimpleNextSlot() {
		int next = SudoUniqueSeqGenerator.getInstance().nextSlot();
		assertTrue(5 == next);
	}
	
	private Runnable createRunnable() {
		return new Runnable() {
			@Override
			public void run() {
				int next = SudoUniqueSeqGenerator.getInstance().nextSlot();
				System.out.println(Thread.currentThread().getName() + " Got: " + next);
				seqs.add(next);
			}
		};
	}
	
	@Test
	public void a_3_ComplexNextSlot() {
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i<=9; i++)
			es.submit(createRunnable());
		es.shutdown();
		
		int next = SudoUniqueSeqGenerator.getInstance().nextSlot();
		assertTrue(16 == next);
		assertTrue(seqs.size()==10);
	}

}
