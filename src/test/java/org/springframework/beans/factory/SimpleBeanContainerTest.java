package org.springframework.beans.factory;

import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-17-22:06
 * @Description:
 */
public class SimpleBeanContainerTest {
    @Test
    public void testCreateBean() throws Exception{
//        BeanFactory beanFactory = new BeanFactory();
//        beanFactory.registerBean("helloService",new HelloService());
//        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
////        assertThat(helloService).isNotNull();
////        assertThat(helloService.sayHello()).isEqualTo("hello");
//        helloService.sayHello();
    }
    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}
