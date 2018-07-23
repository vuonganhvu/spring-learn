package com.higgsup.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CirularDependenciesDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config-dependencies.xml");
        DependencyA dependencyA = (DependencyA) context.getBean("dependencyA");
        DependencyB dependencyB = (DependencyB) context.getBean("dependencyB");
        dependencyA.method();
        dependencyB.method();
    }
}
