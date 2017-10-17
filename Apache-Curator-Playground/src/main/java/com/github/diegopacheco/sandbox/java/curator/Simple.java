package com.github.diegopacheco.sandbox.java.curator;

import java.util.Collection;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Simple {
	public static void main(String[] args) throws Throwable {
			
		   String connectionString = "localhost:2181"; 
	       ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);

	       CuratorFramework curator = CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
	       curator.start();
	       System.out.println(curator);
	  
	       String path = "/diegopacheco/data";
	       Collection<CuratorTransactionResult> results = curator.
	    		   inTransaction().	
	    		   create().forPath(path,"test".getBytes()).
	    		   and().
	    		   setData().forPath(path + "/cool/newdata","{ value: 'Pacheco data' }".getBytes()).
	    		   and().
	    		   commit();
	       
	       System.out.println( results );

	       for ( CuratorTransactionResult result : results ){
	            System.out.println(result.getForPath() + " - " + result.getType());
	       }
    
	}
	       
}
