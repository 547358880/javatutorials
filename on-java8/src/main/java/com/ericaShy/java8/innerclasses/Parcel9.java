package com.ericaShy.java8.innerclasses;

/**
 * 在匿名类中定义字段时， 还能对其执行初始化操作:
 */
public class Parcel9 {

    // Argument must be final or "effectively final" to use within the anonymous inner class
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
