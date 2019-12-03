package com.ericaShy.java8.typeinfo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {

    private Object target;  // 维护一个目标对象

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标生成代理对象
    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开始事务");
        Object returnValue = method.invoke(target, args);
        System.out.println(method.getName());
        System.out.println("关闭事务");
        return returnValue;
    }
}
