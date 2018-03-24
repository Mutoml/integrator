package com.mutoml.basics.design.observer.guava;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-22
 * @time: 18:15
 */
public class DataEvent {
    private String msg;

    public DataEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
