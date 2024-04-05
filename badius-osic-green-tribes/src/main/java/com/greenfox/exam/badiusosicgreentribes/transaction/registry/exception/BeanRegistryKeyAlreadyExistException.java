package com.greenfox.exam.badiusosicgreentribes.transaction.registry.exception;

public class BeanRegistryKeyAlreadyExistException extends RuntimeException{

    public BeanRegistryKeyAlreadyExistException(Object key) {
        super(getMessage(key));
    }

    public BeanRegistryKeyAlreadyExistException(Object key, Throwable cause) {
        super(getMessage(key), cause);
    }

    private static String getMessage(Object missingKey){
        return "Key %s already exists in registry".formatted(missingKey);
    }
}
