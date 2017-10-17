package com.github.diegopacheco.sandbox.java.wildfly.swarm.fun;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class SwarmApplication extends Application {
    public SwarmApplication() {}
}