package com.higgsup.dependencies;

import org.springframework.beans.factory.annotation.Autowired;

public class DependencyB {
    private DependencyA dependencyA;

//    public DependencyB(DependencyA dependencyA) {
//        this.dependencyA = dependencyA;
//    }

    //    @Autowired
    public void setDependencyA(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }

    public void method() {
        System.out.println("DependencyA call method...");
        dependencyA.method();
    }
}
