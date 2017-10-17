package com.github.diegopacheco.sandbox.java.uber.tchannel.main;

import com.uber.tchannel.messages.JsonRequest;
import com.uber.tchannel.messages.JsonResponse;
import com.uber.tchannel.api.handlers.JSONRequestHandler;

public class PingRequestHandler extends JSONRequestHandler<Ping, Pong> {
	
    @Override
    public JsonResponse<Pong> handleImpl(JsonRequest<Ping> request) {
        request.getArg2().retain();
        return new JsonResponse.Builder<Pong>(request)
            .setTransportHeaders(request.getTransportHeaders())
            .setArg2(request.getArg2())
            .setBody(new Pong("pong!"))
            .build();
    }
    
}
