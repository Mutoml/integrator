package com.mutoml.basics.concurrency.procon;

/**
 * Created with IntelliJ IDEA.
 * Description:共享数据模型
 *
 * @author: Mutoml
 * @date: 2018-03-10
 * @time: 15:29
 */
public class DataModel {
    private final int initData;

    public DataModel(int initData) {
        this.initData = initData;
    }

    public int getInitData() {
        return initData;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "initData=" + initData +
                '}';
    }
}
