package com.ericaShy.java8.functional;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionNoAnn {
    String goodbye(String arg);
}

public class FunctionalAnnotation {

    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionNoAnn fna = fa::goodbye;

//        Functional fac = fa;
        Functional f1 = a -> "Goodbye, " + a;
        FunctionNoAnn fnal = a -> "Goodbye, " + a;
    }

}

