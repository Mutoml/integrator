package com.mutoml.basics.design.observer.jdk;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 19:09
 */
public class JdkObserverMain {
    public static void main(String[] args) {
        ConcreteObservable concreteObservable = new ConcreteObservable();
        concreteObservable.addObserver(new ConcreteObserver());
        concreteObservable.setAvable("hello");
    }
}
