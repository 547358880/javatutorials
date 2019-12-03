package com.ericaShy.java8.generics;

/**
 * 你可以将派生类的数组赋值给基类的引用
 */
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        // Runtime type is Apple[], not Fruit[] or Orange[]
        try {
            // Compiler allows you to add Fruit
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);  // java.lang.ArrayStoreException: com.ericaShy.java8.generics.Fruit
        }

        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);      // java.lang.ArrayStoreException: com.ericaShy.java8.generics.Orange
        }
    }
}
