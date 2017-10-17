package com.blogspot.diegopacheco.camel.jms.rr;

public class MessageProtocol {
    public String handleProtocolMessage(String messageText) {
        String responseText;
        if ("MyProtocolMessage".equalsIgnoreCase(messageText)) {
            responseText = "I recognize your protocol message";
        } else {
            responseText = "Unknown protocol message: " + messageText;
        }
        
        return responseText;
    }
}
