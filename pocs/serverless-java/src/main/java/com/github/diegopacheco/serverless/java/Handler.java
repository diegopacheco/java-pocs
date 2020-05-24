package com.github.diegopacheco.serverless.java;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<String, String> {

    private static final Logger LOG = Logger.getLogger(Handler.class);

    @Override
    public String handleRequest(String input, Context context) {
        LOG.info("received: " + input);
        String responseBody = new String("Hello, the current time is " + new Date() + " args: " + input);
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Powered-By", "AWS Lambda & Serverless");
        headers.put("Content-Type", "application/json");
        return "{ \"result\": \"" + responseBody + "\" }";
    }
}