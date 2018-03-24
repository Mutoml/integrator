package com.mutoml.basics.design.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-22
 * @time: 18:15
 */
public class SimpleSubscriber {

    @Subscribe
    public void handleSyncData(DataEvent dataEvent) {
        System.out.println(Thread.currentThread().getName() + "---" + SimpleSubscriber.class.getSimpleName() + dataEvent.getMsg());
    }
}
