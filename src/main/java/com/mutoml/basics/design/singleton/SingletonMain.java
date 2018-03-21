package com.mutoml.basics.design.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 17:18
 */
public class SingletonMain {
    private static final int CIRCLE = 30;

    public static void main(String[] args) {
        for (int i = 0; i < CIRCLE; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // System.out.println(SimpleSingleton.getInstance());

                    //System.out.println(LazyLoadSingleton.getInstance());

                    //System.out.println(SynchronizedLazyLoadSingleton.getInstance());

                    //System.out.println(StaticSingleton.getInstance());

                    //System.out.println(DoubleLockSingleton.getInstance());

                    System.out.println(VolatileDoubleLockSingleton.getInstance());
                }
            }).start();
        }
    }
}
