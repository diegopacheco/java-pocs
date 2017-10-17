package com.ilegra.training.apache.camel.dataformats;

import java.io.Serializable;

public class DrugPojo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String companyName;
	
	public DrugPojo() {}

	public DrugPojo(Long id, String name, String companyName) {
		super();
		this.id = id;
		this.name = name;
		this.companyName = companyName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Drug[id: " + id + " ,name: " + name + " ,Company: " + companyName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrugPojo other = (DrugPojo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
