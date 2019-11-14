package com.ericaShy.java8.interfaces;

public class Implementation implements InterfaceWithDefault {


    @Override
    public void firstMethod() {
        System.out.println("firstMethod");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    public static void main(String[] args) {
        InterfaceWithDefault i = new Implementation();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}
