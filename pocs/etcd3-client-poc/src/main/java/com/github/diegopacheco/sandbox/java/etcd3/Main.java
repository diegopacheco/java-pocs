package com.github.diegopacheco.sandbox.java.etcd3;

import java.util.concurrent.CompletableFuture;

import com.coreos.jetcd.Client;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.kv.DeleteResponse;
import com.coreos.jetcd.kv.GetResponse;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
			Client client = Client.builder().endpoints("http://localhost:2379").build();
			KV kvClient = client.getKVClient();

			ByteSequence key = ByteSequence.fromString("test_key");
			ByteSequence value = ByteSequence.fromString("test_value");
			
			System.out.println("Key: " + key.toStringUtf8() + " Value: " + value.toStringUtf8() );
			
			kvClient.put(key, value).get();

			CompletableFuture<GetResponse> getFuture = kvClient.get(key);
			GetResponse response = getFuture.get();
			System.out.println("Get: ");
			response.getKvs().stream().map( k -> k.getKey().toStringUtf8() ).forEach( System.out::println ) ;
			
			DeleteResponse deleteRangeResponse = kvClient.delete(key).get();	
			System.out.println("Deleted: " + deleteRangeResponse.getDeleted());
			
			client.close();
	}
	
}
