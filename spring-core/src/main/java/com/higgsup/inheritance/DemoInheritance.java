package com.higgsup.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoInheritance {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config-inheritance.xml");
        BaseBeanDefinition baseBeanDefinition = (BaseBeanDefinition) context.getBean("baseBeanDefinition");
        System.out.println("------Base Bean Definition----");
        System.out.println("Message 1: " + baseBeanDefinition.getMessage1());
        System.out.println("Message 2: " + baseBeanDefinition.getMessage2());
        SupperBeanDefinition supperBeanDefinition = (SupperBeanDefinition) context.getBean("supperBeanDefinition");
        System.out.println("Message 1: " + supperBeanDefinition.getMessage1());
        System.out.println("Message 2: " + supperBeanDefinition.getMessage2());
        System.out.println("Message 3: " + supperBeanDefinition.getMessage3());

    }
}
