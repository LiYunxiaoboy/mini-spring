package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-17-22:03
 * @Description:
 */
public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String name, Object bean){
        beanMap.put(name,bean);
    }

    public Object getBean(String name){
        return beanMap.get(name);
    }
}
