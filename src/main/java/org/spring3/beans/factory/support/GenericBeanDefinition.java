package org.spring3.beans.factory.support;

import org.spring3.beans.BeanDefinition;

/**
 * @author xiangzhang
 * @since 2022-05-03 15:55
 */
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;

    public GenericBeanDefinition(){}

    public GenericBeanDefinition(String id, String beanClassName){
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
}
