package com.example.workspace.juc;

/**
 * Creator: L9214
 * Date:2022/5/23 23:17
 */
public class AQS {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            // do something
        } finally {
            lock.unlock();
        }
    }
}
