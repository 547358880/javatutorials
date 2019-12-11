package com.ericaShy.actionjava8.chapter11;

import com.ericaShy.actionjava8.chapter11.v1.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class BestPriceFinder {
    private final List<AsyncShop> shops = Arrays.asList(new AsyncShop("BestPrice"),
            new AsyncShop("LetsSaveBig"),
            new AsyncShop("MyFavoriteShop"),
            new AsyncShop("BuyItAll"),
            new AsyncShop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findParallelPrices(String product) {
        return shops.parallelStream()
            .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
            .collect(Collectors.toList());
    }

    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                    () -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), executor
                )).collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)       // 等待所有异步操作结束
                .collect(Collectors.toList());
    }
}
