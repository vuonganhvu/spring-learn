package com.higgsup.dependencies;

import org.springframework.beans.factory.annotation.Required;

public class InjectionSetter {
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    //    @Required
    public void setId(Long id) {
        System.out.println("Injection setter...");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
