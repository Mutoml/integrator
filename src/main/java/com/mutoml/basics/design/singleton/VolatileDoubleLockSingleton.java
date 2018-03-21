package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:线程安全的双重校验锁
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 19:15
 */
public class VolatileDoubleLockSingleton {

    private static volatile VolatileDoubleLockSingleton volatileDoubleLockSingleton;

    private VolatileDoubleLockSingleton() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static VolatileDoubleLockSingleton getInstance() {
        if (null == volatileDoubleLockSingleton) {
            synchronized (VolatileDoubleLockSingleton.class) {
                if (null == volatileDoubleLockSingleton) {
                    volatileDoubleLockSingleton = new VolatileDoubleLockSingleton();
                }
            }
        }
        return volatileDoubleLockSingleton;
    }
}
