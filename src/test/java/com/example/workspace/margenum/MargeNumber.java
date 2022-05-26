package com.example.workspace.margenum;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Long.MAX_VALUE = 9223372036854775807;
 * max count      = 9223372030000000000;
 */
public class MargeNumber {
    @Test
    public void test() {
        long count = 922337203;
        long currentTimeSecond = System.currentTimeMillis() / 1000;
        long margeValue = marge(count, currentTimeSecond);
        long[] group = resolve(margeValue);
        System.out.println("original input: count=" + count + ",expiration=" + currentTimeSecond);
        System.out.println("marge value:" + margeValue);
        System.out.println("count:" + group[0]);
        System.out.println("expiration:" + group[1]);
    }


    /**
     * 合并统计值和时间
     *
     * @param count      统计值
     * @param expiration 时间，秒数
     * @return 统计值和秒数的合并结果
     */
    private static long marge(long count, long expiration) {
        if (count < 0 || count > 922337203) {
            throw new UnsupportedOperationException("count 超出有效范围[0,922337203]");
        }
        if (expiration < 0L || expiration > 9999999999L) {
            throw new UnsupportedOperationException("expiration 超出有效范围[0,9999999999]");
        }
        return count * 10000000000L + expiration;
    }


    private static long[] resolve(long margeValue) {
        return new long[]{margeValue / 10000000000L, margeValue % 10000000000L};
    }
}
