package com.ericaShy.java8.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletedMachina {

    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));

        try {
            Machina m = cf.get(); // Doesn;t block
            System.out.println(m);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
