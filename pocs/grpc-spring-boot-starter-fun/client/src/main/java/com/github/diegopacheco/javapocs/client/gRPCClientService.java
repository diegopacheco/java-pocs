package com.github.diegopacheco.javapocs.client;

import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MyServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class gRPCClientService {

    //@GrpcClient("static://127.0.0.1:9090")
    @GrpcClient("grpc-server")
    private MyServiceGrpc.MyServiceBlockingStub myServiceStub;

    public gRPCClientService(){}

    public gRPCClientService(MyServiceGrpc.MyServiceBlockingStub myServiceStub){
        this.myServiceStub = myServiceStub;
    }

    public String receiveGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return myServiceStub.sayHello(request).getMessage();
    }

}