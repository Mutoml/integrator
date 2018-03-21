package com.mutoml.basics.concurrency.procon;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:生产者
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 14:59
 */
public class Producer implements Runnable {
    /**
     * 判断线程是否运行
     */
    private volatile boolean isRunning = true;
    /**
     * 共享消息队列
     */
    private BlockingQueue<DataModel> queue;
    /**
     * 总数，原子操作
     */
    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEP_TIME = 1000;

    private static Random random = new Random();

    public Producer(BlockingQueue<DataModel> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("开启的生产者线程为：" + threadId);
        DataModel dataModel;
        try {
            if (isRunning) {
                int sleep = random.nextInt(SLEEP_TIME);
                System.out.println(threadId + "---生产者沉睡：" + sleep + "毫秒");
                Thread.sleep(sleep);
                dataModel = new DataModel(count.incrementAndGet());
                if (queue.offer(dataModel, 2, TimeUnit.SECONDS)) {
                    System.out.println(threadId + "---" + dataModel + "已加入队列");
                } else {
                    System.out.println(threadId + "---" + dataModel + "已队列失败");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
