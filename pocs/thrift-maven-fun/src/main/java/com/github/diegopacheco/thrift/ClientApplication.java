package com.github.diegopacheco.thrift;

import com.github.diegopacheco.thrift.client.CrossPlatformServiceClient;

public class ClientApplication {
    public static void main(String[] args) {
        CrossPlatformServiceClient client = new CrossPlatformServiceClient();
        client.ping();
    }
}
