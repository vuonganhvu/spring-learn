package com.higgsup.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLifecycle {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean-life-cycle.xml");
        applicationContext.getBean("sfsd");
    }
}
