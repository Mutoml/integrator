package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:内部静态类单例
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 18:30
 */
public class StaticSingleton {

    private StaticSingleton() {

    }

    private static class StaticSingletonHandler {
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return StaticSingletonHandler.staticSingleton;
    }
}
