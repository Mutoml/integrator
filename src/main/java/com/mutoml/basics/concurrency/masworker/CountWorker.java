package com.mutoml.basics.concurrency.masworker;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-21
 * @time: 14:57
 */
public class CountWorker extends Worker {
    @Override
    protected Object handle(Object o) {
        final int result = (int) o * (int) o;
        return result;
    }
}
