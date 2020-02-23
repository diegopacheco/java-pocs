package com.github.diegopacheco.audible.fun;

public class FromAddress {

	private String street;
	private String zip;
    
    public FromAddress(){
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet() {
        return street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getZip() {
        return zip;
    }

    public void setAddress(String s){
        this.street = s;
    }
    
}