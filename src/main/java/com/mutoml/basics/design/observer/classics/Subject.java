package com.mutoml.basics.design.observer.classics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 目标
 *
 * @author: Mutoml
 * @date: 2018-03-20
 * @time: 18:29
 */
public interface Subject {

    List<Observer> observerList = new ArrayList<>();

    void attach(Observer observer);

    void detach(Observer observer);

    void notifys();
}
