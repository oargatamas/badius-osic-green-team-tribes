package com.greenfox.exam.badiusosicgreentribes.transaction.registry;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component //FIXME ez az osztály nem lehet így Spring Bean. Spring @Configuration-t kell készíteni hozzá ahol a példányosításon kívül fel is töltöd a hashmap-et a [TransactionType - Class<?>] kulcs érték párokkal
public class BeanRegistry<Key, Bean> {
    private final Map<Key, Class<? extends Bean>> registry = new HashMap<>();

    //FIXME error handling alatt itt arra gondolok, hogy a "registry.containsKey()"-t felhasználva egy elágazásban hibát dobunk ha már van ilyen érték a hasmap-ben.
    // Ezzel elkerülve a típus felülírásokat valamint a "notfound" esetet is egyi lyen szerkezettel célszerű kezelni.
    // Saját Exception típust is bevezethetünk is RuntimeException leszármazottként

    public void add(Key key, Class<? extends Bean> bean){
        registry.put(key, bean);
    } // Todo add proper error handling

    public Class<? extends Bean> get(Key key){
        return registry.get(key);
    } // Todo add proper error handling
}
