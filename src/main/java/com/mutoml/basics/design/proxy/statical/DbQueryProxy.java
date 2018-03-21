package com.mutoml.basics.design.proxy.statical;

import com.mutoml.basics.design.proxy.DbQuery;
import com.mutoml.basics.design.proxy.DbQueryImpl;

/**
 * Created with IntelliJ IDEA.
 * Description:代理类
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 14:51
 */
public class DbQueryProxy implements DbQuery {

    private DbQueryImpl dbQuery;

    @Override
    public String request() {
        //在真正需要的时候才进行创建，创建过程可能很慢
        if (null == dbQuery) {
            dbQuery = new DbQueryImpl();
        }
        return dbQuery.request();
    }
}
