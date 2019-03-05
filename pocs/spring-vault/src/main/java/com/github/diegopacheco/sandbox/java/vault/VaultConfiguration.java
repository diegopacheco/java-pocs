package com.github.diegopacheco.sandbox.java.vault;

import java.net.URI;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
class VaultConfiguration extends AbstractVaultConfiguration {
	
  @Override
  public VaultEndpoint vaultEndpoint() {
      return VaultEndpoint.from(
      		URI.create(System.getProperty("VAULT_DNS",
      				getEnvironment().getRequiredProperty("spring.cloud.vault.uri", String.class)
      		)));
  }

  @Override
  public ClientAuthentication clientAuthentication() {
      return new TokenAuthentication(
      		System.getProperty("VAULT_TOKEN",
      				getEnvironment().getRequiredProperty("spring.cloud.vault.token"))
      		);
  }
  
}
