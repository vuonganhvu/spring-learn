package com.higgsup.event;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class CustomEventHandling {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CustomEventHandling.class);
        ((AnnotationConfigApplicationContext) context).start();
        BeanPublished beanPublished = (BeanPublished) context.getBean("beanPublished");
        CustomEvent customEvent = new CustomEvent();
        customEvent.setName("Anhvv");
        beanPublished.published(customEvent);
    }

    @Bean
    BeanPublished beanPublished() {
        return new BeanPublished();
    }

    @Bean
    CustomHandlingEvent customHandlingEvent() {
        return new CustomHandlingEvent();
    }

    @Bean
    CustomHandlingEvent2 customHandlingEvent2() {
        return new CustomHandlingEvent2();
    }

    static class CustomEvent extends ApplicationEvent {

        private String name;

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public CustomEvent(Object source) {
            super(source);
        }

        public CustomEvent() {
            super("");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class BeanPublished implements ApplicationEventPublisherAware {

        private ApplicationEventPublisher applicationEventPublisher;

        @Override
        public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            this.applicationEventPublisher = applicationEventPublisher;
        }

        public void published(CustomEvent customEvent) {
            this.applicationEventPublisher.publishEvent(customEvent);
        }
    }

    class CustomHandlingEvent implements ApplicationListener<CustomEvent> {

        @Override
        public void onApplicationEvent(CustomEvent event) {
            System.out.println(event.getName());
        }
    }

    class CustomHandlingEvent2 {

//        @EventListener
//        public void onApplicationEvent(ContextStartedEvent event) {
//            System.out.println("On start app...");
//        }

        @EventListener(condition = "false")
        @Order(1)
        public void onApplicationEvent2(CustomEvent event) {
            System.out.println(event.getName());
        }
    }
}
