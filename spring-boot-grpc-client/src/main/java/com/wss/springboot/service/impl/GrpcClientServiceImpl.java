package com.wss.springboot.service.impl;


import com.wss.springboot.libserver.GreeterGrpc;
import com.wss.springboot.libserver.GreeterOuterClass;
import com.wss.springboot.service.GrpcClientService;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientServiceImpl implements GrpcClientService {

    @GrpcClient("local-grpc-server")
    public Channel serverChannel;


    @Override
    public String sendMessage(String name) {
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(serverChannel);
        GreeterOuterClass.HelloReply response = stub.sayHello(GreeterOuterClass.HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}

