package com.github.diegopacheco.sandbox.astyanax.fun;

import java.util.HashMap;

import com.google.common.collect.ImmutableMap;
import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.MutationBatch;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.OperationResult;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.ddl.SchemaChangeResult;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.serializers.StringSerializer;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;

public class MainClient {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Throwable {
		
		CassandraServer.start();
		
		AstyanaxContext<Keyspace> context = new AstyanaxContext.Builder()
	    .forCluster("CassandraNOClusterEmbeded")
	    .forKeyspace("MyKeyspace")
	    .withAstyanaxConfiguration(new AstyanaxConfigurationImpl()      
	        .setDiscoveryType(NodeDiscoveryType.RING_DESCRIBE)
	    )
	    .withConnectionPoolConfiguration(new ConnectionPoolConfigurationImpl("MyConnectionPool")
	        .setPort(9160)
	        .setMaxConnsPerHost(1)
	        .setSeeds("127.0.0.1:9160")
	    )
	    .withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
	    .buildKeyspace(ThriftFamilyFactory.getInstance());
		context.start();
		Keyspace keyspace = context.getClient();
		
		keyspace.createKeyspace(ImmutableMap.<String, Object>builder()
			    .put("strategy_options", ImmutableMap.<String, Object>builder()
			        .put("replication_factor", "1")
			        .build())
			    .put("strategy_class",     "SimpleStrategy")
			        .build()
			     );
		
		try {
			
			keyspace.createColumnFamily(new ColumnFamily<String, String>( "columnFamilyName1",     // Column Family Name
																		    StringSerializer.get(),   // Key Serializer
																		    StringSerializer.get()),new HashMap<>());  // Column Serializer
																
			ColumnFamily<String, String> CF_USER_INFO = new ColumnFamily<String, String>(
					    "columnFamilyName1",     // Column Family Name
					    StringSerializer.get(),   // Key Serializer
					    StringSerializer.get());  // Column Serializer
			
			MutationBatch m = keyspace.prepareMutationBatch();
			m.withRow(CF_USER_INFO, "acct1234")
			  .putColumn("firstname", "john", null)
			  .putColumn("lastname", "smith", null)
			  .putColumn("address", "555 Elm St", null)
			  .putColumn("age", 30, null);
	
		
			  OperationResult<Void> result = m.execute();
			  System.out.println(result);
		} catch (ConnectionException e) {
			System.out.println(e);
		}
		
	}
}
