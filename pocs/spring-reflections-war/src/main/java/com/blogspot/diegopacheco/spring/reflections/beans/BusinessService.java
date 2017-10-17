package com.blogspot.diegopacheco.spring.reflections.beans;

import java.io.Serializable;

public interface BusinessService extends Serializable {
	public Object saveOrUpdate(String name);
}
