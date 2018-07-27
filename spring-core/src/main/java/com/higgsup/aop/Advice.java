package com.higgsup.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {

    public void before(JoinPoint joinPoint) {
        System.out.println("Advice run method before...");
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("Advice run method after...");
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Advice run method around...");
        joinPoint.proceed();
    }

    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("Advice run method after-returning...");
    }

    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("Advice run method after-throwing...");
    }
}
