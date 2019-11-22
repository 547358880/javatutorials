package com.ericaShy.java8.functional;

/**
 * 未绑定的方法引用
 */
class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {

    public static void main(String[] args) {
//        MakeString ms = X::f; // [1]
        TransformX sp = X::f;
        X x = new X();

        System.out.println(sp.transform(x)); // [2]
//        System.out.println(x.f());
    }
}
