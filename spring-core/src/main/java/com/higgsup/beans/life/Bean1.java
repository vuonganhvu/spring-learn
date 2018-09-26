package com.higgsup.beans.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

public class Bean1 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean set Bean Factory...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Bean set Bean Name...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean after set properties ...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Bean set Application context...");
    }


    public void init() {
        System.out.println("Bean init bean...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Bean call postConstruct...");
    }

    public void destroyBean() {
        System.out.println("Bean is destroyBean...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean is destroy...");
    }
}
