package com.mutoml.basics.design.observer.jdk;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 19:02
 */
public class ConcreteObservable extends Observable {
    public void setAvable(String msg) {
        setChanged();
        notifyObservers(msg);
    }

}
