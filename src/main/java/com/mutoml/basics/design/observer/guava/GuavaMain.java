package com.mutoml.basics.design.observer.guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-22
 * @time: 18:17
 */
public class GuavaMain {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("SyncEventBus");
        eventBus.register(new SimpleSubscriber());
        eventBus.register(new AllowConcurrentEventSubscriber());

        eventBus.post(new DataEvent("Hello"));


        ExecutorService executorService = Executors.newCachedThreadPool();
        AsyncEventBus asyncEventBus = new AsyncEventBus(executorService);
        asyncEventBus.register(new SimpleSubscriber());
        asyncEventBus.register(new AllowConcurrentEventSubscriber());

        asyncEventBus.post(new DataEvent("World"));
        asyncEventBus.post(new DataEvent("Fiuncl"));

    }
}
