package com.higgsup.custom;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomScope implements Scope {
    private Map<String, ThreadLocal<Object>> scopedObjects
            = Collections.synchronizedMap(new HashMap<String, ThreadLocal<Object>>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<String, Runnable>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("get CustomScope...");
        if (!scopedObjects.containsKey(name)) {
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            Object o = objectFactory.getObject();
            threadLocal.set(o);
            scopedObjects.put(name, threadLocal);
        }
        return scopedObjects.get(name).get();
    }

    @Override
    public Object remove(String name) {
        System.out.println("remove CustomScope...");
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        System.out.println("registerDestructionCallback CustomScope...");
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return "tenant";
    }

    @Override
    public String getConversationId() {
        return "tenant";
    }
}
