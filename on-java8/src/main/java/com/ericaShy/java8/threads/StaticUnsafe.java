package com.ericaShy.java8.threads;

public class StaticUnsafe {

    public static int counter = 0;

    public int count = 0;

    public void run() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1001; j++) {
                        count++;
                        counter++;
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        StaticUnsafe statics = new StaticUnsafe();
        statics.run();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {}

        System.out.println("count = " + statics.count + ", counter = " + counter);
    }

}
