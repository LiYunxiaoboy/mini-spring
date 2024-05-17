package org.springframework.factory.support;


import org.springframework.BeansException;
import org.springframework.factory.BeanFactory;
import org.springframework.factory.config.BeanDefinition;

/**
 * @author derekyi
 * @date 2020/11/22
 * @describe 实现BeanFactory中的获取Bean的方法，beanMao定义在DefaultSingletonBeanRegistry中
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    // 懒加载，在第一次使用的时候才进行创建bean
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}