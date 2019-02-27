package com.github.diegopacheco.sandbox.java.cass;

import java.io.File;

import org.apache.hadoop.conf.Configuration;

import com.netflix.sstableadaptor.sstable.SSTableSingleReader;

public class SSTableMain {
	
	public static void main(String[] args) throws Throwable {
			
    SSTableSingleReader reader = 
    		new SSTableSingleReader(new File(".").getCanonicalPath() +
    				"/sstable-adaptor-fun/src/main/resources/compressed_bills/mc-2-big-Data.db",
    				new Configuration()
    );
    System.out.println(reader);
    
    long keys = reader.getSstableReader().estimatedKeys();
    System.out.println("Keys: " + keys);
    
	}
	
}
