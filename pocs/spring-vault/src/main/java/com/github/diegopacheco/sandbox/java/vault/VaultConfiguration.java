package com.github.diegopacheco.sandbox.java.vault;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
class VaultConfiguration extends AbstractVaultConfiguration {

  @Override
  public VaultEndpoint vaultEndpoint() {
  		VaultEndpoint ve = VaultEndpoint.create(System.getProperty("VAULT_DNS","127.0.0.1"),8200);
  		ve.setScheme("http");
  		return ve;
  }

  @Override
  public ClientAuthentication clientAuthentication() {
    return new TokenAuthentication(System.getProperty("VAULT_TOKEN","00000000-0000-0000-0000-000000000000"));
  }
  
}
