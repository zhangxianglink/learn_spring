package org.spring3.beans.factory;

import org.spring3.beans.BeanDefinition;

/**
 * @author xiangzhang
 * @since 2022-05-03 13:57
 */
public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String beanId);
}
