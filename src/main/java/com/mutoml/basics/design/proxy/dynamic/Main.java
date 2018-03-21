package com.mutoml.basics.design.proxy.dynamic;

import com.mutoml.basics.design.proxy.DbQuery;
import com.mutoml.basics.design.proxy.DbQueryImpl;
import javassist.*;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-09
 * @time: 15:30
 */
public class Main {
    private static final int CIRCLE = 30000000;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, CannotCompileException, NotFoundException {
        testJdkProxy();
        System.out.println("---------------------------------------------------------");
        testCglibProxy();
        System.out.println("---------------------------------------------------------");
        testJavassistFactoryProxy();
        System.out.println("---------------------------------------------------------");
        testJavassistByteCodeProxy();
    }

    private static void testJavassistByteCodeProxy() throws CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException {
        long begin = System.currentTimeMillis();
        DbQuery dbQuery = createJavassistByteCodeProxy();
        System.out.println("createJavassistByteCodeProxy：" + (System.currentTimeMillis() - begin));

        System.out.println("JavassistByteCodeProxy class：" + dbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            dbQuery.request();
        }
        System.out.println("callJavassistByteCodeProxy：" + (System.currentTimeMillis() - begin));
    }

    private static DbQuery createJavassistByteCodeProxy() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        String dbQueryName = DbQuery.class.getName();
        ClassPool classPool = new ClassPool(true);
        //定义类名
        CtClass ctClass = classPool.makeClass(dbQueryName + "JavassistByteCodeProxy");
        //需要实现的接口
        ctClass.addInterface(classPool.get(dbQueryName));
        //添加构造器
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        //添加类的字段信息
        ctClass.addField(CtField.make("public " + dbQueryName + " real;", ctClass));
        ctClass.addMethod(CtMethod.make("public String request(){" +
                "if(null==real){real= new " + DbQueryImpl.class.getName() + "();}return real.request();}", ctClass));
        //生成动态类
        Class pc = ctClass.toClass();
        //生成动态类实例
        DbQuery dbQuery = (DbQuery) pc.newInstance();
        return dbQuery;
    }

    private static void testJavassistFactoryProxy() throws InstantiationException, IllegalAccessException {
        long begin = System.currentTimeMillis();
        DbQuery dbQuery = createJavassistFactoryProxy();
        System.out.println("createJavassistFactoryProxy：" + (System.currentTimeMillis() - begin));

        System.out.println("JavassistFactoryProxy class：" + dbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            dbQuery.request();
        }
        System.out.println("callJavassistFactoryProxy：" + (System.currentTimeMillis() - begin));
    }

    private static DbQuery createJavassistFactoryProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{DbQuery.class});
        Class proxyClass = proxyFactory.createClass();
        DbQuery dbQuery = (DbQuery) proxyClass.newInstance();
        ((ProxyObject) dbQuery).setHandler(new JavassistDbQueryHandler());
        return dbQuery;
    }

    private static void testCglibProxy() {
        long begin = System.currentTimeMillis();
        DbQuery dbQuery = createCglibProxy();
        System.out.println("createCglibProxy：" + (System.currentTimeMillis() - begin));

        System.out.println("CglibProxy class：" + dbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            dbQuery.request();
        }
        System.out.println("callCglibProxy：" + (System.currentTimeMillis() - begin));
    }

    private static DbQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor());
        enhancer.setInterfaces(new Class[]{DbQuery.class});
        enhancer.setUseCache(true);
        return (DbQuery) enhancer.create();
    }

    private static void testJdkProxy() {
        long begin = System.currentTimeMillis();
        DbQuery dbQuery = createJdkProxy();
        System.out.println("createJdkProxy：" + (System.currentTimeMillis() - begin));

        System.out.println("jdkProxy class：" + dbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            dbQuery.request();
        }
        System.out.println("callJdkProxy：" + (System.currentTimeMillis() - begin));
    }

    private static DbQuery createJdkProxy() {
        DbQuery dbQuery = (DbQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{DbQuery.class}, new JdkDbQueryHandler());
        return dbQuery;
    }
}
