package com.higgsup.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAOP {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-aop.xml");
        ServiceImpl service = context.getBean(ServiceImpl.class);
        service.service3();
//        service.service2();
    }
}
