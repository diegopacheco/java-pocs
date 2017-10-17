package com.ilegra.training.apache.camel.dataformats;

public class SimpleHandler {
	public void handlePojo(DrugPojo dp){
		System.out.println("Pojo Received: " + dp);
	}
}
