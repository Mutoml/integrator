package com.mutoml.basics.design.proxy.statical;

import com.mutoml.basics.design.proxy.DbQuery;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 14:54
 */
public class Main {
    public static void main(String[] args) {
        DbQuery dbQuery = new DbQueryProxy();
        System.out.println(dbQuery.request());
    }
}
