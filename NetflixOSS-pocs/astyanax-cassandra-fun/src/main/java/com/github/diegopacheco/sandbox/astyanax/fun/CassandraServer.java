package com.github.diegopacheco.sandbox.astyanax.fun;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.cassandra.service.CassandraDaemon;

import com.google.common.io.Files;
import com.google.common.io.Resources;

public class CassandraServer {
	public static void start(){
		
		String baseFile = "c:/tmp/"; 
		File dataDir = new File(baseFile);
		Integer port = 9160;
		Integer storagePort = 7000;
		String clusterName = "CassandraNOClusterEmbeded";
		
		try {
			URL configDefault = CassandraServer.class.getClassLoader().getResource("cassandra-server-config.yaml");
			String config = Resources.toString(configDefault,Charset.defaultCharset());
			
			String newConfigFile = config.replace("$DIR$", dataDir.getPath());
			newConfigFile = newConfigFile.replace("$PORT$", Integer.toString(port));
			newConfigFile = newConfigFile.replace("$STORAGE_PORT$",Integer.toString(storagePort));
			newConfigFile = newConfigFile.replace("$CLUSTER$", clusterName);
		
			File configFile = new File(dataDir, "cassandra-server-final.yaml");
			Files.write(newConfigFile, configFile, Charset.defaultCharset());
			System.setProperty("cassandra.config","file:" + configFile.getPath());
		
			new Thread(){
				public void run() {
					CassandraDaemon  cassandra = new CassandraDaemon();
					try {
						cassandra.init(null);
						cassandra.start();
					} catch (Exception e) {
						e.printStackTrace();
					}	
				};
			}.start();
			Thread.sleep(3000l);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
		CassandraServer.start();
	}
}
