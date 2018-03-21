package com.mutoml.basics.concurrency.Future.jdk;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-11
 * @time: 17:04
 */
public class RealData implements Callable<String> {

    private String param;

    public RealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(param);
            try {
                //使用sleep代替很慢的操作
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
