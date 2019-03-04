package com.github.diegopacheco.sandbox.java.vault;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

@Component
public class Example {

  @Autowired
  private VaultOperations operations;

  public void writeSecrets(String userId, String password) {
    Map<String, String> data = new HashMap<String, String>();
    data.put("password", password);
    operations.write(userId, data);
  }

  public String readSensibleData(){
			VaultKeyValueOperations unversioned = operations.opsForKeyValue("aws",
				KeyValueBackend.KV_1);

			VaultResponseSupport<String> response = unversioned
				.get("access_key", String.class);

			return response.getData();
  }
  
  public String readSecrets(String userId) {
    VaultResponseSupport<String> response = operations.read(userId, String.class);
    return response.getData();
  }
  
  //@Value("${aws.access_key}")
  private String awsAccessKey;

  //@Value("${aws.secret_key}")
  private String awsSecretKey;
  
  
}