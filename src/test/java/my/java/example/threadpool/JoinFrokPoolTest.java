package my.java.example.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class JoinFrokPoolTest {
    public static void main(String[] args) {
        for (int i = 1; i < 24; i++)
            CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName() + " sleep.");
                sleep(10000);
            }).join();

        sleep(3000);
        System.out.println("Do Work!");
        int task = 10;
        while (task-- >= 0) {
            CompletableFuture.runAsync(() -> {
                double TPT = Math.pow(2, 2);
                System.out.println(Thread.currentThread().getName() + " work.");
            });
        }

        try {
            ForkJoinPool.commonPool().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
