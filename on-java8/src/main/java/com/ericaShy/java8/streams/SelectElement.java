package com.ericaShy.java8.streams;

import static com.ericaShy.java8.streams.RandInts.*;

public class SelectElement {

    public static void main(String[] args) {
        /**
         * 输出:
         * 258
         * 258
         * 258
         * 402
         */
        System.out.println(rands().findFirst().getAsInt());
        System.out.println(rands().parallel().findFirst().getAsInt());
        System.out.println(rands().findAny().getAsInt());
        System.out.println(rands().parallel().findAny().getAsInt());
    }

}
