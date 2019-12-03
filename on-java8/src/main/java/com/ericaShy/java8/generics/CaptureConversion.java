package com.ericaShy.java8.generics;

public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
//        f1(raw);  //warnings

        f2(raw); // No warnings
        Holder rawBasic = new Holder();
      //  rawBasic.set(new Object());  // warnings

        f2(rawBasic);
    }
}
