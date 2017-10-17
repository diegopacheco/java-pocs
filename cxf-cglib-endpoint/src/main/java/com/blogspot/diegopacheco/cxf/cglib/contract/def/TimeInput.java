package com.blogspot.diegopacheco.cxf.cglib.contract.def;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://timeinput")
@XmlAccessorType(XmlAccessType.FIELD)
public class TimeInput implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String companyName;
	
	public TimeInput() {}

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

}
