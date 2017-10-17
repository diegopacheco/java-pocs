package com.github.diegopacheco.sandbox.java.netflixoss.karyon.poc.jersey;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Path("/math")
public class SimpleMathResource {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleMathResource.class);

	@GET
    @Path("sum/{v1}/{v2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sum(@PathParam("v1") Double v1,
    					@PathParam("v2") Double v2) {
        try {
        	JSONObject response = new JSONObject();
            response.put("Message", "Sum [" + v1 + "] + [" + v2 + "] + = " + (v1+v2) + " | from Netflix OSS");
            return Response.ok(response.toString()).build();
        } catch (JSONException e) {
            logger.error("Error creating json response.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
	
}
