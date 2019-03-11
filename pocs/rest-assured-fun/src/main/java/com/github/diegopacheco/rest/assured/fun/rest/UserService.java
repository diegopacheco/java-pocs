package com.github.diegopacheco.rest.assured.fun.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;  

@Path("/UserService") 
public class UserService {  

	 UserDao userDao = new UserDao();  
  
	 @GET 
   @Path("/users/xml") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsersXml(){ 
      return userDao.getAllUsers(); 
   }
	 
	 @GET 
   @Path("/users/json") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<User> getUsersJson(){ 
      return userDao.getAllUsers(); 
   }
	 
}