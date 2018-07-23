package com.higgsup.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoCustomScope {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-config-scope.xml");
        TenantBean foo = (TenantBean) ctx.getBean("foo", TenantBean.class);
        foo.sayHello();
        TenantBean bar = (TenantBean) ctx.getBean("bar", TenantBean.class);
        bar.sayHello();
//        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
    }
}
