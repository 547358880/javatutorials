package com.ericaShy.java8.interfaces;

public abstract class AbstractAccess {

    AbstractAccess() {

    }

    private void m1() {}

    //private abstract void m1a();    // illegal

    protected void m2() {}

    protected abstract void m2a();

    void m3() {}

    abstract void m3a();
}
