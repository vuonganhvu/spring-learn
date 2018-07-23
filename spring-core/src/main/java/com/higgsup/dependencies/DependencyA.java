package com.higgsup.dependencies;

import org.springframework.beans.factory.annotation.Autowired;

public class DependencyA {
//    private DependencyB dependencyB;

//    public DependencyA(DependencyB dependencyB) {
//        this.dependencyB = dependencyB;
//    }

    public void setDependencyB(DependencyB dependencyB) {
//        this.dependencyB = dependencyB;
    }

    public void method() {
        System.out.println("DependencyB call method...");
//        dependencyB.method();
    }
}
