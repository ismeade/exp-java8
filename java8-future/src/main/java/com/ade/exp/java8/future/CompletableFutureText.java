package com.ade.exp.java8.future;

import java.util.concurrent.*;

/**
 * Created by liyang on 17-9-30.
 */
public class CompletableFutureText {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("1. " + Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Test";
        }, service).thenApplyAsync(s -> {
            System.out.println("2. " + Thread.currentThread().getId());
            return s.length();
        }, service);
        System.out.println("pass");
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
