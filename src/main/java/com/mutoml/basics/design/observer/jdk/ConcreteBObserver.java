package com.mutoml.basics.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-22
 * @time: 17:11
 */
public class ConcreteBObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(Thread.currentThread().getName() + "----ConcreteBObserver--" + o.getClass().getSimpleName() + arg);
    }
}
