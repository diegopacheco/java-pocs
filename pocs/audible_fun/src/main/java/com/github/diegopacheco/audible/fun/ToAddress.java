package com.github.diegopacheco.audible.fun;

public class ToAddress {
	
	private String street;
	private String zip;
	private String state;
	
    public ToAddress(){}
    
    public String getState() {
        return state;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ToAddress: " + zip + " " + state + " " + street;
    }
}