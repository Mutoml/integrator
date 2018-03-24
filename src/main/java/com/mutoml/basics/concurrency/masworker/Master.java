package com.mutoml.basics.concurrency.masworker;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:Master-Worker的好处是能把大任务分解成若干个小任务，并执行。
 *
 * @author: Mutoml
 * @date: 2018-03-11
 * @time: 16:42
 */
public class Master {
    /**
     * 任务队列
     */
    private Queue<Object> taskQueue = new ConcurrentLinkedQueue<>();
    /**
     * worker进程队列
     */
    private Map<String, Thread> workerQueue = new ConcurrentHashMap<>();
    /**
     * 结果队列
     */
    private Map<String, Object> resultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int workerCount) {
        worker.setObjectQueue(taskQueue);
        worker.setObjectMap(resultMap);
        for (int i = 0; i < workerCount; i++) {
            workerQueue.put(String.valueOf(i), new Thread(worker));
        }
    }

    public void commit(Object object) {
        taskQueue.offer(object);
    }

    public void excute() {
        for (Map.Entry<String, Thread> entry :
                workerQueue.entrySet()) {
            entry.getValue().start();
        }
    }

    public Object getResult(String key) {
        return resultMap.get(key);
    }
}
