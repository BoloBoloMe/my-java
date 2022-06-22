package my.java.util.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author: luojingyan
 * create time: 2022/6/22 11:02
 **/
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(x -> ++x)
                .whenComplete((r, e) -> System.out.println(r));
    }
}
