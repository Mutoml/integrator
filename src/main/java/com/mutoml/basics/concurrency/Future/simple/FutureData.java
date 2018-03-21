package com.mutoml.basics.concurrency.Future.simple;

/**
 * Created with IntelliJ IDEA.
 * Description:封装RealData的Future类
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 20:56
 */
public class FutureData implements Data {

    private RealData realData;
    private boolean isReady = false;

    public void setRealData(RealData realData) {
        synchronized (this) {
            if (isReady) {
                return;
            }
            this.realData = realData;
            isReady = true;
            System.out.println("setRealData当前线程id:" + Thread.currentThread().getId());
            notifyAll();//realData已经被注入，通知getResult();
        }
    }

    @Override
    public String getResult() {
        synchronized (this) {
            while (!isReady) {
                try {
                    wait();//一直等待，直到RealData被注入
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("getResult当前线程id:" + Thread.currentThread().getId());
        return realData.getResult();
    }
}
