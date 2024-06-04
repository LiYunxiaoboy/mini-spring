package org.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodAfterAdvice;

/**
 * @Author: LiYunxiao
 * @Date: 2024-06-04-13:28
 * @Description:
 */
public class MethodAfterAdviceInterceptor implements MethodInterceptor {
    private MethodAfterAdvice afterAdvice;

    public MethodAfterAdviceInterceptor(MethodAfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = methodInvocation.proceed();
        this.afterAdvice.after(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return result;
    }
}
