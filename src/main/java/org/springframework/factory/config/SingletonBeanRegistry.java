package org.springframework.factory.config;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-17-22:32
 * @Description:
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
