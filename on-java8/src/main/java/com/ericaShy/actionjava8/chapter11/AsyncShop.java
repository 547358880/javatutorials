package com.ericaShy.actionjava8.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop {

    private final String name;
    private final Random rand;

    public String getName() {
        return name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public AsyncShop(String name) {
        this.name = name;
        rand = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>(); // 创建CompletableFuture对象，它会包含计算的结果
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    private double calculatePrice(String product) {
        Unit.delay();
//        if (true) throw new RuntimeException("product not available");
        return rand.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
