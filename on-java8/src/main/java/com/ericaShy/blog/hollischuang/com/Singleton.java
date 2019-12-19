package com.ericaShy.blog.hollischuang.com;

import java.io.Serializable;

/**
 * 使用双重校验锁方式显示单例
 */
public class Singleton implements Serializable {

    private volatile static Singleton singleton;

    private Singleton() {}

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    // 防止序列化破坏单例模式代码
    private Object readResolve() {
        return singleton;
    }

}
