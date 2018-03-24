package com.mutoml.basics.concurrency.masworker;

import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-21
 * @time: 11:51
 */
public class Worker implements Runnable {

    private Queue<Object> objectQueue;

    private Map<String, Object> objectMap;

    @Override
    public void run() {
        while (true) {
            final Object o = objectQueue.poll();
            if (null == o) {
                return;
            }
            objectMap.put(o.toString(), handle(o));
        }
    }

    protected Object handle(Object o) {
        return null;
    }


    public void setObjectQueue(Queue<Object> objectQueue) {
        this.objectQueue = objectQueue;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }
}
