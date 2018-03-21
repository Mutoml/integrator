package com.mutoml.basics.design.proxy.dynamic;

import com.mutoml.basics.design.proxy.DbQuery;
import com.mutoml.basics.design.proxy.DbQueryImpl;
import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 15:28
 */
public class JavassistDbQueryHandler implements MethodHandler {
    private DbQuery dbQuery;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (null == dbQuery) {
            dbQuery = new DbQueryImpl();
        }
        return dbQuery.request();
    }
}
