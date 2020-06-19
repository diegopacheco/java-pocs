package com.github.diegopacheco.thrift;

import com.github.diegopacheco.thrift.server.CrossPlatformServiceServer;
import org.apache.thrift.transport.TTransportException;

public class ServerApplication {

    public static void main(String[] args) throws TTransportException {
        CrossPlatformServiceServer server = new CrossPlatformServiceServer();
        server.start();
    }

}