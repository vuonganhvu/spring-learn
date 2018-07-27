package com.higgsup;

import com.higgsup.config.AppConfig;
import com.higgsup.service.IService;
import com.higgsup.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = ((AnnotationConfigApplicationContext) context).getEnvironment();
        environment.setActiveProfiles("prod");
        environment.getSystemProperties().put("profile", "dev");
        ((AnnotationConfigApplicationContext) context).register(AppConfig.class);
        ((AnnotationConfigApplicationContext) context).refresh();
        IService service = (IService) context.getBean("iService");
        IStudentService iStudentService = (IStudentService) context.getBean("iStudentService");
        service.print();
        iStudentService.createStudent();
    }
}
