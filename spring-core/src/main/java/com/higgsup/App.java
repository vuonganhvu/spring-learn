package com.higgsup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Entitlement ent = (Entitlement) context.getBean("alias_ent");
        Student stu = (Student) context.getBean("alias_stud");
        System.out.println("student bean name is " + stu.getName());
        System.out.println("entitlement bean name is " + ent.getName());
        System.out.println("entitlement bean time is " + ent.getTime());
        System.out.println(context.getBean("clientServiceConstructor"));
        System.out.println(context.getBean("clientServiceFactoryStatic"));
        System.out.println(context.getBean("defaultServiceLocator"));
        System.out.println(context.getBean("clientServiceFactoryInstance"));
    }
}
