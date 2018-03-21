package com.mutoml.basics.concurrency.Future.simple;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 21:09
 */
public class Client {
    public Data getResult(String request) {
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final RealData realData = new RealData(request);
                futureData.setRealData(realData);
            }
        }).start();
        return futureData;
    }
}
