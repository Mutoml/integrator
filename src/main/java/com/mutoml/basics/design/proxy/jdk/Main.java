package com.mutoml.basics.design.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 11:56
 */
public class Main {
    public static void main(String[] args) {
        //静态代理
        StaticProxyHello staticProxyHello = new StaticProxyHello();
        System.out.println(staticProxyHello.sayHello("Cool Guy"));
        //动态代理
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, new LogInvocationHandler(new HelloMap()));
        System.out.println(hello.sayHello("Cool Gay"));
    }
}
