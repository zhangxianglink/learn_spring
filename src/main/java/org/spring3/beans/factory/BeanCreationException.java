package org.spring3.beans.factory;

import org.spring3.beans.BeansException;

/**
 * @author xiangzhang
 * @since 2022-05-03 16:46
 */
public class BeanCreationException extends BeansException {
    private String beanName;

    public BeanCreationException(String msg) {
        super(msg);
    }

    public BeanCreationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeanCreationException(String msg, String beanName) {
        super("Error creating bean with name '" + beanName + " : " + msg);
        this.beanName =beanName;
    }
    public BeanCreationException(String msg, String beanName, Throwable cause) {
        this(msg,beanName);
        initCause(cause);
    }

    public String getBeanName() {
        return this.beanName;
    }


}
