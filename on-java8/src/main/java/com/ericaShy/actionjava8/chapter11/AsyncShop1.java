package com.ericaShy.actionjava8.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop1 {

    private final String name;
    private final Random rand;

    public AsyncShop1(String name) {
        this.name = name;
        rand = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPriceAsync(String product) {
       return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        Unit.delay();
        if (true) throw new RuntimeException("product not available");
        return rand.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
