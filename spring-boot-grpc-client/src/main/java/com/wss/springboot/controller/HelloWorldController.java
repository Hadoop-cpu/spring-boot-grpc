package com.wss.springboot.controller;


import com.wss.springboot.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    public String printMessage(String beginName, String endName) {
        return helloWorldService.helloWorld(beginName, endName);
    }
}

