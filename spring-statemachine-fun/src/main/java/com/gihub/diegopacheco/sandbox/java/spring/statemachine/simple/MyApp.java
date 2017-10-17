package com.gihub.diegopacheco.sandbox.java.spring.statemachine.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Component
public class MyApp {
	
	@Autowired
    StateMachine<States, Events> stateMachine;

    void doSignals() {
        stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
    }
	
}
