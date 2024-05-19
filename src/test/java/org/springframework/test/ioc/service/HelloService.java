package org.springframework.test.ioc.service;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-19-20:18
 * @Description:
 */
public class HelloService {
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
