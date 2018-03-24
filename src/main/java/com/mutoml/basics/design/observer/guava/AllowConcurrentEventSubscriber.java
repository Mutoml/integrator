package com.mutoml.basics.design.observer.guava;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-22
 * @time: 18:22
 */
public class AllowConcurrentEventSubscriber {

    @Subscribe
    @AllowConcurrentEvents()
    public void handleAsyncData(DataEvent dataEvent) {
        System.out.println(Thread.currentThread().getName() + "-------------" + AllowConcurrentEventSubscriber.class.getSimpleName() + dataEvent.getMsg());
    }
}
