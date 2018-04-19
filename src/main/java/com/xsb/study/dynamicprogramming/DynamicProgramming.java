package com.xsb.study.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2018-04-08 09:38
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] memory = new int[11];
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        int max = dynamicProgramming.cutRod(price, 1);
        System.out.println(max);

//        for (int i = 0; i < memory.length; i++) {
//            memory[i] = Integer.MIN_VALUE;
//        }
//        max = dynamicProgramming.curRodWithMemory(price, 4, memory);
//        System.out.println(max);

//        dynamicProgramming.bottomUpCutRod(price, 4);
//        dynamicProgramming.bottomUpCutRod(price, 5);
//        dynamicProgramming.bottomUpCutRod(price, 10);

        dynamicProgramming.bottomUpCutRod(price, 4);
    }

    private int cutRod(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int tmpPrice = price[i] + cutRod(price, n - i);
            if (tmpPrice > q) {
                q = tmpPrice;
            }
        }
        return q;
    }

    private int curRodWithMemory(int[] price, int n, int[] memory) {
        if (memory[n] >= 0) {
            return memory[n];
        }
        if (n == 0) {
            memory[n] = 0;
            return 0;
        }

        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int tmpPrice = price[i] + curRodWithMemory(price, n - i, memory);
            if (tmpPrice > q) {
                q = tmpPrice;
            }
        }
        memory[n] = q;
        return q;
    }

    private List<Integer> bottomUpCutRod(int[] price, int n) {
        List<Integer> result = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            result.add(0);
        }

        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(price[j] + result.get(i - j), q);
            }
            result.set(i, q);
        }
        System.out.println(result);
        return result;
    }

    private void extendedBottomUpCutRod(int[] price, int n) {
        List<Integer> result = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            result.add(0);
        }

        List<Integer> s = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            s.add(0);
        }

        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (q < price[j] + result.get(i - j)) {
                    q = price[j] + result.get(i - j);
                    s.set(i, j);
                }
            }
            result.set(i, q);
        }
        System.out.println(result);
        System.out.println(s);

        while (n > 0) {
            System.out.println(s.get(n));
            n = n - s.get(n);
        }
    }
}
