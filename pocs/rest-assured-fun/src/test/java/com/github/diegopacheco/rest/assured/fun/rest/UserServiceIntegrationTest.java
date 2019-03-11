package com.github.diegopacheco.rest.assured.fun.rest;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceIntegrationTest extends JerseyTest {
	 
  @Override
  protected Application configure() {
      return new ResourceConfig(UserService.class);
  }
  
  @Test
  public void givenGetUsersListAllUsersJsonShouldBeOKJersey() {
      Response response = target("/UserService/users/json").request().get();
      assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response.getStatus());
      assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE)); 
      String content = response.readEntity(String.class);
      assertNotNull(content);
      System.out.println(content);
  }
  
}
