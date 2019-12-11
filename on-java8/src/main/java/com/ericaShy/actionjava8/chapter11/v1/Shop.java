package com.ericaShy.actionjava8.chapter11.v1;

import com.ericaShy.actionjava8.chapter11.Discount;
import com.ericaShy.actionjava8.chapter11.Unit;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private final String name;
    private final Random rand;

    public Shop(String name) {
        this.name = name;
        rand = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[rand.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public double getPrice1(String product) {
        return calculatePrice(product);
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
        return rand.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
