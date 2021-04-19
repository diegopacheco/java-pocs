package com.github.diegopacheco.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class MyLambdaHandler implements RequestHandler<Map<String,String>, String> {
    @Override
    public String handleRequest(Map<String,String> event, Context context) {
        if(null==event.get("message")) throw new IllegalArgumentException("message missing");

        String message = event.get("message");
        return message;
    }
}