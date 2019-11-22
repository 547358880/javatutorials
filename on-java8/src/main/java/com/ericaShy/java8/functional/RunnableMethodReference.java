package com.ericaShy.java8.functional;


// 方法引用与Runnable接口的结合使用
class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class RunnableMethodReference {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(() -> {
            System.out.println("lambda");
        }).start();

        new Thread(Go::go).start();
    }
}
