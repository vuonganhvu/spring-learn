package com.higgsup.custom;

import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleProcessorCustom implements LifecycleProcessor {
    @Override
    public void onRefresh() {
        System.out.println("Start onRefresh...");
    }

    @Override
    public void onClose() {
        System.out.println("Start onClose...");
    }

    @Override
    public void start() {
        System.out.println("Start start...");
    }

    @Override
    public void stop() {
        System.out.println("Start stop...");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
