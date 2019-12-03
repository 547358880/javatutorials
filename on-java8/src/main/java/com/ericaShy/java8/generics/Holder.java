package com.ericaShy.java8.generics;

import java.util.Objects;

public class Holder<T> {

    private T value;

    public Holder() {}

    public Holder(T val) {
        value =val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder && Objects.equals(value, ((Holder) obj).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);

//        Holder<Fruit> fruit = apple;  // Cannot upcast
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();

        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {
            System.out.println(e);      // java.lang.ClassCastException: com.ericaShy.java8.generics.Apple cannot be cast to com.ericaShy.java8.generics.Orange
        }

        //fruit.set(new Apple());     // Cannot call set
        //fruit.set(new Fruit());     // Cannot call set
        System.out.println(fruit.equals(d));  // false
    }
}
