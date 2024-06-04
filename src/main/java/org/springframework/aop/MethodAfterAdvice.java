package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: LiYunxiao
 * @Date: 2024-06-04-13:34
 * @Description:
 */
public interface MethodAfterAdvice extends AfterAdvice{
    void after(Method method, Object[] args, Object target) throws Throwable;
}
