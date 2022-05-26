package com.example.workspace.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Creator: luojingyan
 * Date:2022/5/25 0:12
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread subT = new Thread(() -> {
//            while (true) {
            System.out.println("线程将被挂起");
            LockSupport.park();
            System.out.println("线程被唤醒");
            System.out.println("线程的中断状态：" + Thread.currentThread().isInterrupted());
//            }
        });
        // 就算主线程结束了非守卫线程也不会退出 jvm
        subT.setDaemon(false);

        subT.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("休眠被中断！");
        }
        // 请求子线程中断
        subT.interrupt();
    }
}
