package com.ericaShy.java8.typeinfo;

/**
 * instanceof 与 class的差别
 */

class Base {}

class Derived extends Base {}

public class FamilyVsExactType {

    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instance of Derived " + (x instanceof Derived));
        System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class" + (x.getClass() == Base.class));
        System.out.println("x.getClass == Derived.class " + (x.getClass() == Derived.class));
        System.out.println("x.getClass.equals(Base.class) " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass.equals(Derived.class) " + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        /**
         * 输出:
         * x instanceof Base true
         * x instance of Derived false
         * Base.isInstance(x) true
         * Derived.isInstance(x) false
         * x.getClass() == Base.class true
         * x.getClass == Derived.class false
         * x.getClass.equals(Base.class) true
         * x.getClass.equals(Derived.class) false
         */
        test(new Base());
        System.out.println("************************");
        /**
         * 输出：
         * x instanceof Base true
         * x instance of Derived true
         * Base.isInstance(x) true
         * Derived.isInstance(x) true
         * x.getClass() == Base.classfalse
         * x.getClass == Derived.class true
         * x.getClass.equals(Base.class) false
         * x.getClass.equals(Derived.class) true
         */
        test(new Derived());
    }
}
