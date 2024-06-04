package org.springframework.test.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.*;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.CglibAopProxy;
import org.springframework.aop.framework.JdkDynamicAopProxy;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodAfterAdviceInterceptor;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.test.common.WorldServiceAfterAdvice;
import org.springframework.test.common.WorldServiceBeforeAdvice;
import org.springframework.test.common.WorldServiceInterceptor;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class DynamicProxyTest {
    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() {
        WorldServiceImpl proxy = (WorldServiceImpl) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testFactoryProxy() {
        // jdk动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxyJdk = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxyJdk.explode();

        // cglib动态代理
        advisedSupport.setProxyTargetClass(true);
        WorldService proxyCglib = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxyCglib.explode();
    }

    /**
     * 前置增强
     */
    @Test
    public void testBeforeAdvice() {
        MethodBeforeAdvice worldServiceBeforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(worldServiceBeforeAdvice);
        advisedSupport.setMethodInterceptor(methodBeforeAdviceInterceptor);
        WorldService proxyJdk = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxyJdk.explode();

    }

    /**
     * 后置增强
     */
    @Test
    public void testAfterAdvice() {
        // 增强的方法实例
        MethodAfterAdvice methodAfterAdvice = new WorldServiceAfterAdvice();
        // 拦截器
        MethodAfterAdviceInterceptor methodAfterAdviceInterceptor = new MethodAfterAdviceInterceptor(methodAfterAdvice);
        // 设置切面的拦截器等内容
        advisedSupport.setMethodInterceptor(methodAfterAdviceInterceptor);

        WorldService proxyJdk = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxyJdk.explode();
    }
}
