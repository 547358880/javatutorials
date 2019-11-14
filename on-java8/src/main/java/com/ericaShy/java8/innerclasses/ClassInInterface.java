package com.ericaShy.java8.innerclasses;

/**
 * 接口内部的类
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }
    }

    static void main(String[] args) {
        new Test().howdy();
    }
}
