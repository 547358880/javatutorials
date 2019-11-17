package com.ericaShy.java8.reuse;

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    /**
     * 输出
     * Art constructor
     * Drawing constructor
     * Cartoon constructor
     */
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
