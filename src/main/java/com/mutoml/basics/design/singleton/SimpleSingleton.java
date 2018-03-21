package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:线程安全的单例类
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 17:16
 */
public class SimpleSingleton {
    private static SimpleSingleton simpleSingleton = new SimpleSingleton();

    private SimpleSingleton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SimpleSingleton getInstance() {
        return simpleSingleton;
    }

}
