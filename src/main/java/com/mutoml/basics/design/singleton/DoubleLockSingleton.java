package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:双重校验锁单例
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 18:40
 */
public class DoubleLockSingleton {
    private static DoubleLockSingleton doubleLockSingleton;

    private DoubleLockSingleton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DoubleLockSingleton getInstance() {
        if (null == doubleLockSingleton) {
            synchronized (DoubleLockSingleton.class) {
                if (null == doubleLockSingleton) {
                    doubleLockSingleton = new DoubleLockSingleton();
                }
            }
        }
        return doubleLockSingleton;
    }
}
