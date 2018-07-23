package com.higgsup.custom;

import org.springframework.beans.factory.InitializingBean;

public class TenantBean implements InitializingBean {
    private final String name;

    public TenantBean(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(
                String.format("Hello from %s of type %s",
                        this.name,
                        this.getClass().getName()));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init bean TenantBean...");
    }
}
