package com.github.diegopacheco.rest.assured.fun.rest;

import static io.restassured.RestAssured.given;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class UserServiceIntegrationRATest extends JerseyTest {

	@BeforeClass
	public static void setup() {
		RestAssured.port = Integer.valueOf(9998);
		RestAssured.basePath = "/";
		RestAssured.baseURI = "http://localhost";
	}

	@Override
	protected Application configure() {
		return new ResourceConfig(UserService.class);
	}

	@Test
	public void givenGetUsersListAllUsersJsonShouldBeOKRestAssured() {
		given().when().get("/UserService/users/json").then().statusCode(200);
	}

}
