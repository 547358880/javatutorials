package com.ericaShy.java8.interfaces;

/**
 * 接口中的静态方法
 */
public interface Operations {

    void execute();

    static void runOps(Operations... ops) {
        for (Operations op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }
}
