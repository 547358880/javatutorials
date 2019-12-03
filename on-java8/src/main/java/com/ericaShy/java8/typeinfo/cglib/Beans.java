package com.ericaShy.java8.typeinfo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Beans implements MethodInterceptor {
    private PropertyChangeSupport propertyChangeSupport;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public static Object newInstance(Class clazz) {
        Beans interceptor = new Beans();
        Enhancer e = new Enhancer();
        e.setSuperclass(clazz);
        e.setCallback(interceptor);
        Object bean = e.create();
        interceptor.propertyChangeSupport = new PropertyChangeSupport(bean);
        return bean;
    }

    static final Class[] C = new Class[0];
    static final Object[] emptyArgs = new Object[0];

    /**
     *
     * 方法名.invoke(对象)
     */
//    @Override
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        System.out.println("开始拦截!");
//        Object returnValue = proxy.invokeSuper(obj, args);
//        System.out.println("结束拦截!");
//        return returnValue;
//    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object retValFromSuper = null;

        try {
            if (!Modifier.isAbstract(method.getModifiers())) {
                retValFromSuper = proxy.invokeSuper(obj, args);
            }
        } finally {
            String name = method.getName();
            if (name.equals("addPropertyChangeListener")) {
                addPropertyChangeListener((PropertyChangeListener) args[0]);
            } else if (name.equals("removePropertyChangeListener")) {
                removePropertyChangeListener((PropertyChangeListener) args[0]);
            }

            if (name.startsWith("set") && args.length == 1 && method.getReturnType() == Void.TYPE) {
                char[] propName = name.substring("set".length()).toCharArray();
                propName[0] = Character.toLowerCase(propName[0]);
                propertyChangeSupport.firePropertyChange(new String(propName), null, args[0]);
            }
        }

        return retValFromSuper;
    }

    public static void main(String[] args) {
        Bean bean = (Bean) Beans.newInstance(Bean.class);
        bean.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt);
            }
        });

        bean.setSampleProperty("Test");
    }
}
