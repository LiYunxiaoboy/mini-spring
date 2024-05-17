package org.springframework.factory;

import org.springframework.BeansException;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-17-22:29
 * @Description: bean容器
 */
public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param name
     * @return
     * @throws BeansException bean不存在时
     */
    Object getBean(String name) throws BeansException;
}
