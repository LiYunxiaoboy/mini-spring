package org.springframework.beans.factory.config;

import lombok.Data;
import org.springframework.beans.PropertyValues;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-17-22:30
 * @Description: BeanDefinition实例保存bean的信息，包括class类型、方法构造参数、是否为单例等，此处简化只包含class类型
 */
@Data
public class BeanDefinition {
    private Class beanClass;
    private PropertyValues propertyValues;
    // 记录 bean 的初始化方法名字
    private String initMethodName;
    // 记录 bean 的销毁方法的名字
    private String  destroyMethodName;

    public BeanDefinition() {
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
