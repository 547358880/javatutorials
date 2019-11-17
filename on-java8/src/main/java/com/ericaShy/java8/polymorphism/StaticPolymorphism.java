package com.ericaShy.java8.polymorphism;

/**
 * 静态方法不具备多态性
 */
class StaticSuper {

    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }

    static void isStatic() {
        System.out.println("StaticSuper.isStatic");
    }

}

class StaticSub extends StaticSuper {

    public static String staticGet() {
        return "derived staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {

    /**
     * 输出:
     * Base staticGet()
     * Derived dynamicGet()
     *
     * StaticSuper.isStatic
     */
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());

        StaticSub.isStatic();
    }

}
