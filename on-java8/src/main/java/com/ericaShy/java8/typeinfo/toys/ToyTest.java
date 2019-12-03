package com.ericaShy.java8.typeinfo.toys;

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName()); // getCanonicalName() 也是产生完整类名（除内部类和数组外，对大部分类产生的结果与 getName() 相同）
        System.out.println("************************************");
        System.out.println();
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.ericaShy.java8.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Cant't find FancyToy");
            System.exit(1);
        }

        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;

        try {
            // Requires no-arg constructor
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
    }


}
