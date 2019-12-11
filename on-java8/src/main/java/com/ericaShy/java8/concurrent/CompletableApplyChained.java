package com.ericaShy.java8.concurrent;

import com.ericaShy.java8.onjava.Timer;

import java.util.concurrent.CompletableFuture;

public class CompletableApplyChained {

    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);

        System.out.println(timer.duration());
    }

}
