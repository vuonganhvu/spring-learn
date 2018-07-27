package com.higgsup.test;

import com.higgsup.aop.Advice;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Advice.class)
public class ComponentTest {
}
