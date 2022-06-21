package com.example.workspace.random;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 生成 n 个在区间 [0, m] 中，不重复的随机数
 * <p>
 * Creator: L9214
 * Date:2022/6/21 21:47
 */
public class RandomNumber {
    public static void main(String[] args) {
        Set<Integer> set = getRandomNums(999, 1000);
        System.out.printf("set: %s \nsize: %s ", set, set.size()).println();
    }


    /**
     * 生成 n 个在区间 [0, m] 中，不重复的随机数。
     * 实现思路：
     * 当 0 < n < m/2 时, 生成 n 个大小介于 [0, m] 的随机数集合, 输出这个集合；
     * 当 m/2 <= n < m 时, 生成 n 个大小介于 [0, m] 的随机数集合, 输出整数集 [0, m] 中随机数集合的补集。
     *
     * @param n 输出的随机数个数
     * @param m 随机数最大值，必须大于 0
     * @return n 个在区间 [0, m] 中，不重复的随机数
     */
    static Set<Integer> getRandomNums(int n, int m) {
        if (m <= 0 || n <= 0) throw new UnsupportedOperationException("n & m must be greater than 0");
        if (n > m) throw new UnsupportedOperationException("n cannot be greater than m");
        if (n == m) return IntStream.range(0, m).boxed().collect(Collectors.toSet());
        int size = n < m / 2 ? n : m - n;
        Set<Integer> set = new HashSet<>(size);
        Random r = new Random(System.currentTimeMillis());
        do {
            set.add(r.nextInt(m) % (m - 1));
        } while (set.size() < size);
        if (n == size) return set;
        return IntStream.range(0, m).filter(x -> !set.contains(x)).boxed().collect(Collectors.toSet());
    }

}
