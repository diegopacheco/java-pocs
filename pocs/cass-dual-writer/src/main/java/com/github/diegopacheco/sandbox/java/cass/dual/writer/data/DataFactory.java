package com.github.diegopacheco.sandbox.java.cass.dual.writer.data;

import java.util.stream.IntStream;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.BusinessDAO;

public class DataFactory {
	
	public void generateRecords(int soManyRecords,BusinessDAO dao) {
		IntStream stream = IntStream.iterate(0, i -> i + 1);
		stream
			.limit(soManyRecords)
			.forEach( i->  { 
				dao.insertData("k"+i+"k", "v"+i+"v");
			});
	}
}
