package com.wss.springboot.service.impl;


import com.wss.springboot.client.HelloWorldClient;
import com.wss.springboot.service.HelloWorldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Resource
    private HelloWorldClient client;

    @Override
    public String helloWorld(String beginName, String endName) {
        return client.sayHello(beginName, endName);
    }
}

