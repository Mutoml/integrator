package com.mutoml.basics.design.observer.classics;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 18:33
 */
public class ConcreteSubject implements Subject {

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifys() {
        for (Observer observer :
                observerList) {
            observer.update();
        }
    }
}
