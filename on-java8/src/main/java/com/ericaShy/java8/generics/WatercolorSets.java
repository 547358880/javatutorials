package com.ericaShy.java8.generics;

import com.ericaShy.java8.generics.watercolors.Watercolors;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.EnumSet;
import java.util.Set;

import static com.ericaShy.java8.generics.watercolors.Watercolors.*;
import static com.ericaShy.java8.onjava.Sets.*;

public class WatercolorSets {

    public static void main(String[] args) {
        EnumSet<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        System.out.println(set1.size());

    }

}
