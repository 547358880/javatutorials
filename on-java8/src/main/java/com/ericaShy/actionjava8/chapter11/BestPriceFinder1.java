package com.ericaShy.actionjava8.chapter11;

import com.ericaShy.actionjava8.chapter11.v1.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder1 {
    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

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
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

//    public List<String> findParallelPrices(String product) {
//        return shops.parallelStream()
//            .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//            .collect(Collectors.toList());
//    }
//
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))          // 使用另一个异步任务构造期望的future,申请折扣
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)       // 等待所有异步操作结束
                .collect(Collectors.toList());
    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))          // 使用另一个异步任务构造期望的future,申请折扣
                        .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }

    public List<String> findPricesInUSD(String product) {
        List<CompletableFuture<Double>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice1(product)))
                        // 创建第二个独立的任务
                        .map(future -> future.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)), (price, rate) -> price * rate))
                        .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)       // 等待所有异步操作结束
                .map(price -> " price is " + price)
                .collect(Collectors.toList());
    }

    public List<String> findPricesInUSDJava7(String product) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            final Future<Double> futureRate = executor.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    return ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD);
                }
            });
            Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    double priceInEUR = shop.getPrice1(product);
                    return priceInEUR * futureRate.get();
                }
            });
            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = new ArrayList<>();
        for (Future<Double> priceFuture : priceFutures) {
            try {
                prices.add(/*shop.getName() +*/ " price is " + priceFuture.get());
            }
            catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    public void printPricesStream(String product) {
        Stream<CompletableFuture<String>> test = findPricesStream(product);
        CompletableFuture[] futures = test.map(f -> f.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();
    }
}
