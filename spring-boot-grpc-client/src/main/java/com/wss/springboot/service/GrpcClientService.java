package com.wss.springboot.service;

/**
 * @ClassName: GrpcClientServic
 * @Author: admin
 * @Date: 2022/5/9
 * @Time: 18:48
 */
public interface GrpcClientService {

    /**
     * @param name
     * @return
     */
     String sendMessage(String name);
}
