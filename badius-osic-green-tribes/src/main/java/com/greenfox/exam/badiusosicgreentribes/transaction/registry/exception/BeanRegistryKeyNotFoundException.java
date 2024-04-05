package com.greenfox.exam.badiusosicgreentribes.transaction.registry.exception;

public class BeanRegistryKeyNotFoundException extends RuntimeException{

    public BeanRegistryKeyNotFoundException(Object key) {
        super(getMessage(key));
    }

    public BeanRegistryKeyNotFoundException(Object key, Throwable cause) {
        super(getMessage(key), cause);
    }

    private static String getMessage(Object missingKey){
        return "Key %s Not Found in registry".formatted(missingKey);
    }
}
