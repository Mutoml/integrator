package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:大粒度同步锁懒加载单例
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 18:13
 */
public class SynchronizedLazyLoadSingleton {
    private static SynchronizedLazyLoadSingleton simpleSingleton;

    private SynchronizedLazyLoadSingleton() {
    }

    public static SynchronizedLazyLoadSingleton getInstance() {
        if (null == simpleSingleton) {
            simpleSingleton = new SynchronizedLazyLoadSingleton();
        }
        return simpleSingleton;
    }
}
