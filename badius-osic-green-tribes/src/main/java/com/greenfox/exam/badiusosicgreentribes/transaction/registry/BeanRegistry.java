package com.greenfox.exam.badiusosicgreentribes.transaction.registry;


import com.greenfox.exam.badiusosicgreentribes.transaction.registry.exception.BeanRegistryKeyAlreadyExistException;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.exception.BeanRegistryKeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class BeanRegistry<Key, BeanType> {
    private final Map<Key, Class<? extends BeanType>> registry = new HashMap<>();

    public void add(Key key, Class<? extends BeanType> bean){
        if(registry.containsKey(key)){
            throw new BeanRegistryKeyAlreadyExistException(key);
        }
        registry.put(key, bean);
    }

    public Class<? extends BeanType> get(Key key){
        if(!registry.containsKey(key)){
            throw new BeanRegistryKeyNotFoundException(key);
        }
        return registry.get(key);
    }
}
