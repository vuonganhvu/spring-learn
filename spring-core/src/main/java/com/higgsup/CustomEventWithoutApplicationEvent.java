package com.higgsup;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;

public class CustomEventWithoutApplicationEvent {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                CustomEventWithoutApplicationEvent.class);
        MyEvenPublisherBean bean = context.getBean(MyEvenPublisherBean.class);
        Thread thread = new Thread(() -> bean.sendMsg("A test message"));
        thread.start();
        System.out.println("Thread main name is " + Thread.currentThread().getName());

    }

    @Bean
    AListenerBean2 listenerBean2() {
        return new AListenerBean2();
    }

    @Bean
    AListenerBean listenerBean() {
        return new AListenerBean();
    }

    @Bean
    MyEvenPublisherBean publisherBean() {
        return new MyEvenPublisherBean();
    }

    //we are not autowiring ApplicationEventPublisher but implementing ApplicationEventPublisherAware this time
    private static class MyEvenPublisherBean implements ApplicationEventPublisherAware {

        ApplicationEventPublisher publisher;

        public void sendMsg(String msg) {
            publisher.publishEvent(new MyEvent(msg));

        }

        @Override
        public void setApplicationEventPublisher(
                ApplicationEventPublisher applicationEventPublisher) {
            this.publisher = applicationEventPublisher;

        }
    }

    private static class AListenerBean {

        @EventListener
        public void onMyEvent(MyEvent event) {
            System.out.println("Thread event name is " + Thread.currentThread().getName());
            System.out.println("event received: " + event.getMsg());

        }

    }

    private static class MyEvent {
        private final String msg;


        public MyEvent(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    private class AListenerBean2 {

        @EventListener
        public void onMyEvent(MyEvent event) {
            System.out.println("Thread event name is " + Thread.currentThread().getName());
            System.out.println("event received 2: " + event.getMsg());

        }

    }
}
