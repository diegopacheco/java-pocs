package com.github.diegopacheco.sandbox.java.uber.tchannel.main.simple;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

import com.uber.tchannel.api.TChannel;
import com.uber.tchannel.api.TFuture;
import com.uber.tchannel.messages.RawRequest;
import com.uber.tchannel.messages.RawResponse;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, InterruptedException, ExecutionException {
        // create another TChannel for client.
        TChannel client = new TChannel.Builder("ping-client").build();
        RawRequest request = new RawRequest.Builder("ping-server", "ping-handler")
        		.setTimeout(5000)
                .setHeader("Marco")
                .setBody("Ping!")
                .build();

        // make an asynchronous request
        TFuture<RawResponse> responseFuture = client
                .makeSubChannel("ping-server").send(
                request,
                InetAddress.getByName("127.0.0.1"),
                8080
        );

        // block and wait for the response
        try (RawResponse response = responseFuture.get()) {
            System.out.println(response);
        }
         client.shutdown();
        
    }
	
}
