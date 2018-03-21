package com.mutoml.basics.concurrency.Future.simple;

/**
 * Created with IntelliJ IDEA.
 * Description:真实数据类
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 20:50
 */
public class RealData implements Data {
    private String result = "";

    public RealData(String param) {
        //RealData构建过程可能很慢
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
        result = stringBuilder.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
