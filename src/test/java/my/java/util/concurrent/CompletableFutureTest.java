package my.java.util.concurrent;


import org.junit.jupiter.api.Test;

/**
 * CompletableFutureTest 示例
 *
 * @author: luojingyan
 * create time: 2022/6/22 11:02
 **/
public class CompletableFutureTest {

    /**
     * 一元依赖
     */
    @Test
    public static void uniRefCase() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 1);
        // cf2 依赖 cf1
        CompletableFuture<Integer> cf2 = cf1.thenApply(x -> ++x);
        // cf2 依赖 cf3
        CompletableFuture<Integer> cf3 = cf2.thenApplyAsync(x -> ++x);
        // cf3 依赖 cf4
        CompletableFuture<Integer> cf4 = cf3.whenComplete((r, e) -> System.out.println(r));
    }


    /**
     * 二元依赖
     */
    @Test
    public static void biRefCase() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 2);
        // cf3 依赖 cf1 和 cf2
        CompletableFuture<Integer> cf3 = cf1.thenCombine(cf2, Integer::sum);

    }


    /**
     * 多元依赖
     */
    @Test
    public static void multiRefCase() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> 3);
        // cf4 依赖 cf1, cf2, cf3
        CompletableFuture<Void> cf4 = CompletableFuture.allOf(cf1, cf2, cf3).thenAcceptAsync(System.out::println);
    }
}
