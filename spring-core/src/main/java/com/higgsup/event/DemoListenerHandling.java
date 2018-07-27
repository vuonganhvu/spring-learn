package com.higgsup.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class DemoListenerHandling {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoListenerHandling.class);
        ((AnnotationConfigApplicationContext) context).start();
        ((AnnotationConfigApplicationContext) context).close();
        ((AnnotationConfigApplicationContext) context).stop();
//        ((AnnotationConfigApplicationContext) context).refresh();
    }

    @Bean
    ApplicationEventStart applicationEventStart() {
        return new ApplicationEventStart();
    }

    @Bean
    ApplicationEventStop applicationEventStop() {
        return new ApplicationEventStop();
    }

    @Bean
    ApplicationEventRefreshed applicationEventRefreshed() {
        return new ApplicationEventRefreshed();
    }

    @Bean
    ApplicationEventClosed applicationEventClosed() {
        return new ApplicationEventClosed();
    }

    class ApplicationEventStart implements ApplicationListener<ContextStartedEvent> {
        @Override
        public void onApplicationEvent(ContextStartedEvent event) {
            System.out.println("On start application...");
        }
    }

    class ApplicationEventStop implements ApplicationListener<ContextStoppedEvent> {

        @Override
        public void onApplicationEvent(ContextStoppedEvent event) {
            System.out.println("On stop application...");
        }
    }

    class ApplicationEventRefreshed implements ApplicationListener<ContextRefreshedEvent> {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println("On refreshed application...");
        }
    }

    class ApplicationEventClosed implements ApplicationListener<ContextClosedEvent> {
        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.out.println("On closed application...");
        }
    }
}

