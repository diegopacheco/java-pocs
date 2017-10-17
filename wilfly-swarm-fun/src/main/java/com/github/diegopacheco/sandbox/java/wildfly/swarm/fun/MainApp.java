package com.github.diegopacheco.sandbox.java.wildfly.swarm.fun;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSDeployment;

public class MainApp {
	public static void main(String[] args) throws Throwable {
		Container container = new Container();

		JAXRSDeployment deployment = new JAXRSDeployment(container);
		deployment.addResource(DateResource.class);
		container.start().deploy(deployment);
	}
}
