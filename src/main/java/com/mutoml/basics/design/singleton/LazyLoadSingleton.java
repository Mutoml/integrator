package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:线程不安全的懒加载单例类
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 17:16
 */
public class LazyLoadSingleton {
    private static LazyLoadSingleton simpleSingleton;

    private LazyLoadSingleton() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static LazyLoadSingleton getInstance() {
        if (null == simpleSingleton) {
            simpleSingleton = new LazyLoadSingleton();
        }
        return simpleSingleton;
    }

}
