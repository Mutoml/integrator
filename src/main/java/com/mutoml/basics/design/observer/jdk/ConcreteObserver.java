package com.mutoml.basics.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 19:04
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("------" + o.getClass().getSimpleName() + arg);
    }
}
