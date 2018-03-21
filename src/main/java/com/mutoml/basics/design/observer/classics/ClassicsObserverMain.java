package com.mutoml.basics.design.observer.classics;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 18:39
 */
public class ClassicsObserverMain {
    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();
        Observer observerA = new ConcreteObserver();
        Observer observerB = new ConcreteObserver();

        subject.attach(observerA);
        subject.attach(observerB);
        subject.notifys();

        subject.detach(observerB);
        subject.notifys();
    }
}
