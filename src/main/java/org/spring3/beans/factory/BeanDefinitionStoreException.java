package org.spring3.beans.factory;

import org.spring3.beans.BeansException;

import java.beans.Beans;

/**
 * @author xiangzhang
 * @since 2022-05-03 16:46
 */
public class BeanDefinitionStoreException extends BeansException {
    public BeanDefinitionStoreException(String msg) {
        super(msg);
    }

    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
