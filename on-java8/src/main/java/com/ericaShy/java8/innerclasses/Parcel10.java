package com.ericaShy.java8.innerclasses;

/**
 * Using "instance initialization" to perform construction
 */
public class Parcel10 {

    private String name = "xujing";

    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;

            // Instance initialization for each object
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }

                System.out.println("out name is " + name);
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 11.395F);
    }
}
