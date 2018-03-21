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
    private Queue<Object> queue = new ConcurrentLinkedQueue<>();
    /**
     * worker进程队列
     */
    private Map<String, Thread> worderQueue = new ConcurrentHashMap<>();
    /**
     * 结果队列
     */
    private Map<String, Object> result = new ConcurrentHashMap<>();
}
