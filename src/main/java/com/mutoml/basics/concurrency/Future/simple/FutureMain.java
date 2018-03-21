package com.mutoml.basics.concurrency.Future.simple;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 21:13
 */
public class FutureMain {
    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //直接返回，构造的是FutureData
                    Data data = client.getResult("name");
                    //模仿处理其他逻辑
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("数据：" + data.getResult());
                }
            }).start();
        }

    }
}
