package com.mutoml.basics.concurrency.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-21
 * @time: 17:05
 */
public class ReentrantLockMain {
    public static void main(String[] args) {
        Thread threadA = new Thread(createTryLockTask(), "A");
        Thread threadB = new Thread(createTryLockTask(), "B");
        threadA.start();
        threadB.start();

    }

    public static Runnable createLockTask() {
        return new Runnable() {
            @Override
            public void run() {
                Lock lock = new ReentrantLock();
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println("Sleep：" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("InterruptedException：" + Thread.currentThread().getName());
                } finally {
                    lock.unlock();
                    System.out.println("unlock：" + Thread.currentThread().getName());
                }
            }
        };
    }

    public static Runnable createTryLockTask() {
        return new Runnable() {
            @Override
            public void run() {
                Lock lock = new ReentrantLock();
                if (lock.tryLock()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Sleep：" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("InterruptedException：" + Thread.currentThread().getName());
                    } finally {
                        lock.unlock();
                        System.out.println("unlock：" + Thread.currentThread().getName());
                    }
                }
            }
        };
    }
}
