package org.spring3.beans;

/**
 * @author xiangzhang
 * @since 2022-05-03 16:43
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg){
        super(msg);
    }
    public BeansException(String msg, Throwable cause){
        super(msg, cause);
    }
}
