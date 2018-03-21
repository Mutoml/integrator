package com.mutoml.basics.design.observer.classics;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 18:38
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("被通知。。。");
    }
}
