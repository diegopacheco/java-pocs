package com.github.diegopacheco.sandbox.java.vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultOperations;

@Component
public class ServiceUsingSecrets {

  @Autowired
  private VaultOperations operations;
  
  //@Value("${aws.access_key}")
  private String awsAccessKey;

  //@Value("${aws.secret_key}")
  private String awsSecretKey;

  
  public String readSensibleData(){
			return readSecrets("secret","test");
  }
  
  private String readSecrets(String path,String subPath) {
  	VaultKeyValueOperations ops = operations.opsForKeyValue(path, KeyValueBackend.KV_2);
    return ops.get(subPath).getData().toString();
  }
  
}