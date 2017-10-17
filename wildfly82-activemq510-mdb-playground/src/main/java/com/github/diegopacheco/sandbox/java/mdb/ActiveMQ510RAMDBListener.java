package com.github.diegopacheco.sandbox.java.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "test") })
public class ActiveMQ510RAMDBListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                System.out.println("RA ActiveMQ 5.10 - Wildfly 8.2 - Got Message: " + ((TextMessage) message).getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
