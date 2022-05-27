package com.example.workspace.juc;

/**
 * Creator: luojingyan
 * Date:2022/5/23 23:17
 */
public class AqsUseCase {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();
        lock.lock();
        try {
            // do something

        } finally {
            lock.unlock();
        }
    }
}
