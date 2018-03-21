package com.mutoml.basics.design.proxy.dynamic;

import com.mutoml.basics.design.proxy.DbQuery;
import com.mutoml.basics.design.proxy.DbQueryImpl;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:cglib的动态代理
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 15:08
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {
    private DbQuery dbQuery;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (null == dbQuery) {
            dbQuery = new DbQueryImpl();
        }
        return dbQuery.request();
    }
}
