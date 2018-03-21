package com.mutoml.basics.design.proxy.jdk;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 11:54
 */
public class StaticProxyHello implements Hello {
    private Hello hello = new HelloMap();

    @Override
    public String sayHello(String msg) {
        return hello.sayHello(msg);
    }
}
