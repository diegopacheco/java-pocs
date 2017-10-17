package com.blogspot.diegopacheco.cxf.cglib.contract.def;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://timeoutput")
@XmlAccessorType(XmlAccessType.FIELD)
public class TimeOutput implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String companyName;	
	private Collection<String> deals;
	
	public TimeOutput() {}	

	public TimeOutput(String name, String companyName, Collection<String> deals) {
		this.name = name;
		this.companyName = companyName;
		this.deals = deals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Collection<String> getDeals() {
		return deals;
	}

	public void setDeals(Collection<String> deals) {
		this.deals = deals;
	}
	
}
