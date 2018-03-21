package com.mutoml.basics.concurrency.procon;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:消费者
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 15:31
 */
public class Consumer implements Runnable {
    /**
     * 判断线程是否运行
     */
    private volatile boolean isRunning = false;
    /**
     * 共享消息队列
     */
    private BlockingQueue<DataModel> queue;

    private static final int SLEEP_TIME = 1000;

    private static Random random = new Random();

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("开启的消费者线程为：" + threadId);
        try {
            if (true) {
                DataModel dataModel = queue.take();
                if (null != dataModel) {
                    int re = dataModel.getInitData() * dataModel.getInitData();
                    System.out.println(threadId + "---" + MessageFormat.format("{0}*{1}={2}", dataModel.getInitData(), dataModel.getInitData(), re));
                    int sleep = random.nextInt(SLEEP_TIME);
                    System.out.println(threadId + "---消费者沉睡：" + sleep + "毫秒");
                    Thread.sleep(sleep);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
