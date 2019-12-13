package com.ericaShy.other.copy;

class A {
    public void f() {
        System.out.println("A.f()");
    }

    protected void g() {
        System.out.println("A.g()");
    }

    private void h() {
        System.out.println("A.h()");
    }
}

class B extends A {
    @Override
    public void f() {
        System.out.println("B.f()");
    }

    public void g() {
        System.out.println("B.g()");
    }

    public void h() {
        System.out.println("B.h()");
    }
}

public class TestOverrider {

    public static void main(String[] args) {
        A a = new B();
        a.f();
        a.g();
//        a.h();
    }
}
