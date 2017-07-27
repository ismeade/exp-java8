package com.ade.exp.java8.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 *
 * Created by liyang on 2017/3/14.
 */
public class Main {

    private static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig1"),
            new Shop("LetsSaveBig2"),
            new Shop("LetsSaveBig3"),
            new Shop("LetsSaveBig4"),
            new Shop("LetsSaveBig5"),
            new Shop("LetsSaveBig6"),
            new Shop("LetsSaveBig7"),
            new Shop("LetsSaveBig8"),
            new Shop("LetsSaveBig9"),
            new Shop("LetsSaveBig10"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    public static List findPrice1(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List findPrice2(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List findPrice3(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product)))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static List<String> findPrice4(String product) {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Callable<String>> tasks = new ArrayList<>();
        for (Shop shop : shops) {
            tasks.add(() -> shop.getName() + " price is " + shop.getPrice(product));
        }
        try {
            List<Future<String>> futures = service.invokeAll(tasks);
            List<String> list = new ArrayList<>();
            for (Future<String> future : futures) {
                list.add(future.get());
            }
            return list;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(findPrice1("MyPhone27"));
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " msecs");

        start = System.currentTimeMillis();
        System.out.println(findPrice2("MyPhone27"));
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " msecs");

        start = System.currentTimeMillis();
        System.out.println(findPrice3("MyPhone27"));
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " msecs");

        start = System.currentTimeMillis();
        System.out.println(findPrice4("MyPhone27"));
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " msecs");
    }

}
