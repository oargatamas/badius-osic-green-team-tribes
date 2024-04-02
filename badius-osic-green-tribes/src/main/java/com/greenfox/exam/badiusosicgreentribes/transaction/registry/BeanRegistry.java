package com.greenfox.exam.badiusosicgreentribes.transaction.registry;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BeanRegistry<Key, Bean> {
    private final Map<Key, Class<? extends Bean>> registry = new HashMap<>();

    public void add(Key key, Class<? extends Bean> bean){
        registry.put(key, bean);
    } // Todo add proper error handling

    public Class<? extends Bean> get(Key key){
        return registry.get(key);
    } // Todo add proper error handling
}
