package com.mutoml.basics.concurrency.procon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 18:09
 */
public class ProconMain {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<DataModel> queue = new LinkedBlockingQueue<>(10);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Producer producer = new Producer(queue);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);

        Consumer consumer = new Consumer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        executorService.execute(producer);
        executorService.execute(producer1);
        executorService.execute(producer2);

        executorService.execute(consumer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Thread.sleep(10 * 1000);
        producer.stop();
        producer1.stop();
        producer2.stop();

        Thread.sleep(3000);
        executorService.shutdown();
    }
}
