package com.mutoml.basics.design.proxy.jdk;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 11:43
 */
public class HelloMap implements Hello {

    @Override
    public String sayHello(String msg) {
        return this.getClass().getSimpleName() + "：" + msg;
    }
}
