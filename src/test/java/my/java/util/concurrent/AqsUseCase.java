package my.java.util.concurrent;

import my.java.util.concurrent.ReentrantLock;

/**
 * Creator: luojingyan
 * Date:2022/5/23 23:17
 */
public class AqsUseCase {

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
