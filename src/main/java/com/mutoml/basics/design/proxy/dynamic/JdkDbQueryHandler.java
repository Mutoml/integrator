package com.mutoml.basics.design.proxy.dynamic;

import com.mutoml.basics.design.proxy.DbQuery;
import com.mutoml.basics.design.proxy.DbQueryImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:jdk的动态代理
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 15:05
 */
public class JdkDbQueryHandler implements InvocationHandler {

    private DbQuery dbQuery;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (null == dbQuery) {
            dbQuery = new DbQueryImpl();
        }
        return dbQuery.request();
    }
}
