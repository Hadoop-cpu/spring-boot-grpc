package com.wss.springboot.service;


import com.wss.springboot.libserver.Greeting;
import com.wss.springboot.libserver.HelloWorldServiceGrpc;
import com.wss.springboot.libserver.Person;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @ClassName: GreeterService
 * @Author: admin
 * @Date: 2022/5/9
 * @Time: 14:05
 */
@Slf4j
@GrpcService
public class HelloServer extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
        log.info("request:{}", request);
        responseObserver.onNext(Greeting.newBuilder().setMessage("当前时间为" + System.currentTimeMillis()).build());
        responseObserver.onCompleted();
    }

}
