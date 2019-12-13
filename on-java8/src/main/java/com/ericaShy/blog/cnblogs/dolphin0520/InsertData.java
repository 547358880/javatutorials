package com.ericaShy.blog.cnblogs.dolphin0520;

public class InsertData {
    private Object object = new Object();

    public void insert() {
        synchronized (object) {}
    }

    public synchronized void insert1() {}

    public synchronized void insert2() {}

    public void insert3() {}

    public void insert4() {
        synchronized (this) {}
    }
}
