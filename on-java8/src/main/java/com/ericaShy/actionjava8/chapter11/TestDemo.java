package com.ericaShy.actionjava8.chapter11;

import com.ericaShy.actionjava8.chapter11.v1.Shop;

import java.util.concurrent.Future;

public class TestDemo {

    public static void main(String[] args) {
        AsyncShop1 shop = new AsyncShop1("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

}
