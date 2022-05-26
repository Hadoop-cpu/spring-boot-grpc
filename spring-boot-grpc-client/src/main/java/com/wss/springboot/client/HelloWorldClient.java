package com.wss.springboot.client;

import com.wss.springboot.libserver.Greeting;
import com.wss.springboot.libserver.HelloWorldServiceGrpc;
import com.wss.springboot.libserver.Person;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName: HelloWorldClient
 * @Author: admin
 * @Date: 2022/5/10
 * @Time: 13:57
 */
@Slf4j
@Component
public class HelloWorldClient {

    /**
     * 阻塞stub
     */
    private HelloWorldServiceGrpc.HelloWorldServiceBlockingStub serviceBlockingStub;

    @PostConstruct
    public void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9898).usePlaintext().build();
        serviceBlockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
    }

    public String sayHello(String firstName, String lastName) {
        Person person = Person.newBuilder().setFirstName(firstName).setLastName(lastName).build();
        Greeting greeting = serviceBlockingStub.sayHello(person);
        return greeting.getMessage();
    }
}
