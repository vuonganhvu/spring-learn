package com.higgsup.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class ExtensionContainer implements BeanPostProcessor, Ordered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Pre process initialization bean...");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After process initialization bean...");
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
