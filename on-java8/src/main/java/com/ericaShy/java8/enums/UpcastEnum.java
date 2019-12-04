package com.ericaShy.java8.enums;

// No values() method if you upcast an enum

import java.util.ArrayList;
import java.util.EnumSet;

enum Search { WITHER, YON }

public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.WITHER; // Upcast

//        e.values(); // o values in Enum

        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
