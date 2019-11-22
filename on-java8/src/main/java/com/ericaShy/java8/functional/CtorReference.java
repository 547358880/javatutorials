package com.ericaShy.java8.functional;

/**
 * 构造函数引用
 */
class Dog {
    String name;
    int age = -1;
    Dog() { name = "stray"; }
    Dog(String name) { this.name = name; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

public class CtorReference {

    /*
        int[]::new 是一个构造器引用， 它有一个参数:数组的长度, 等价于x -> new int[x]
     */
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        Make1Arg m1a = Dog::new;
        Make2Args m2a = Dog::new;

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
    }

}
