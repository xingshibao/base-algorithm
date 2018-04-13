package com.xsb.study.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author shibao.xing
 * @since 2018-04-13 16:34
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int i = partition(array, low, high);
            sort(array, low, i - 1);
            sort(array, i + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int x = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < x) {
                switchNumer(array, ++i, j);
            }
        }
        switchNumer(array, i + 1, high);
        return i + 1;
    }

    private void switchNumer(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
