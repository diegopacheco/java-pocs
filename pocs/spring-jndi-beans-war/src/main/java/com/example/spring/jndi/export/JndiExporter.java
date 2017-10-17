package com.example.spring.jndi.export;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jndi.JndiTemplate;

public class JndiExporter implements InitializingBean, DisposableBean {

	private String jndiName;

	private Object bean;

	private final JndiTemplate jndiTemplate = new JndiTemplate();

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {

		this.jndiName = jndiName;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public void afterPropertiesSet() throws Exception {
		jndiTemplate.bind(jndiName, bean);
	}

	public void destroy() throws Exception {
		if (bean != null && jndiName != null
				&& bean == jndiTemplate.lookup(jndiName)) {
			jndiTemplate.unbind(jndiName);
		}
	}
}