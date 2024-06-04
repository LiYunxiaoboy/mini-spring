package org.springframework.test.common;

import org.springframework.aop.MethodAfterAdvice;

import java.lang.reflect.Method;

/**
 * @Author: LiYunxiao
 * @Date: 2024-06-04-13:38
 * @Description:
 */
public class WorldServiceAfterAdvice implements MethodAfterAdvice {
    @Override
    public void after(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterAdvice: do something After the earth explodes");
    }
}
