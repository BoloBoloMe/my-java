package com.example.workspace.threadpool;

import java.util.concurrent.*;

public class RejectedExecutionHandlerTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>(1),
                        r -> {
                            Thread thread = new Thread(r);
                            thread.setName("property_calculate_executor_" + thread.getId());
                            thread.setDaemon(true);
                            return thread;
                        });

        try {
            // 在死循环中提交任务
            while (true) {
//                executor.execute(() -> {
//                });
                CompletableFuture.runAsync(() -> {
                }, executor);
            }
        } catch (RejectedExecutionException e) {
            System.err.println("触发拒绝策略");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
