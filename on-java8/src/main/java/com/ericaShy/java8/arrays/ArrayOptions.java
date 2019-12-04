package com.ericaShy.java8.arrays;

/**
 * Initialization & re-assignment of arrays
 */

import static com.ericaShy.java8.onjava.ArrayShow.*;

public class ArrayOptions {

    public static void main(String[] args) {
        BerylliumSphere[] a;    // Uninitialized local
        BerylliumSphere[] b = new BerylliumSphere[5];

        // The references inside the array are automatically initialized to null
        show("b", b);
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }

        // Aggregate initialization
        BerylliumSphere[] d = {
            new BerylliumSphere(),
            new BerylliumSphere(),
            new BerylliumSphere()
        };

        // Dynamic aggregate initialization
        a = new BerylliumSphere[] {
            new BerylliumSphere(), new BerylliumSphere()
        };
    }

}
