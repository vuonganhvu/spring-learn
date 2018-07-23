package com.higgsup.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config-dependencies.xml");
        System.out.println("InjectionConstructor bean year is " + ((InjectionConstructor) context.getBean("injectionConstructor")).getYears());
        System.out.println("InjectionSetter bean year is " + ((InjectionSetter) context.getBean("injectionSetter")).getId());
    }
}
