package com.mutoml.basics.design.proxy;

import com.mutoml.basics.design.proxy.DbQuery;

/**
 * Created with IntelliJ IDEA.
 * Description:具体主题
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 14:48
 */
public class DbQueryImpl implements DbQuery {
    public DbQueryImpl() {
        try {
            //模拟具体主题耗时操作，如连接数据库
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request result";
    }
}
