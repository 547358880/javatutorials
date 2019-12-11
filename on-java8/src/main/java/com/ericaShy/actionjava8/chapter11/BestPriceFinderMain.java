package com.ericaShy.actionjava8.chapter11;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder1 bestPriceFinder = new BestPriceFinder1();

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = ((System.nanoTime() - start) / 1000000);
        System.out.println(msg + " done in " + duration + " msecs");
    }

    public static void main(String[] args) {
//        execute("stream", () -> bestPriceFinder.findPrices("myPhone275"));

        //execute("findParallelPrices", () -> bestPriceFinder.findParallelPrices("myPhone275"));

        System.out.println("**********************************");

        execute("findPricesFuture", () -> bestPriceFinder.findPricesFuture("myPhone275"));
    }

}
