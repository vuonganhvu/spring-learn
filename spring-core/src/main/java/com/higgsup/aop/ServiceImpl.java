package com.higgsup.aop;

public class ServiceImpl {
    public void service1() {
        System.out.println("// Do service 1...");
    }

    public void service2() {
        System.out.println("// Do service 2...");
    }

    public void service3() throws Exception {
        System.out.println("// Do service 3...");
        throw new Exception();
    }

    public void service4() {
        System.out.println("// Do service 4...");
    }

    public void service5() {
        System.out.println("// Do service 5...");
    }
}
