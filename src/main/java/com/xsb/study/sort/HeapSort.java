package com.xsb.study.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author shibao.xing
 * @since 2018-04-12 20:00
 */
public class HeapSort {

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private void maxHeapify(int[] array, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest;

        if (l < heapSize && array[l] > array[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapSize && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = array[largest];
            array[largest] = array[i];
            array[i] = tmp;

            maxHeapify(array, largest, heapSize);
        }
    }

    private void buildMaxHeap(int[] array, int heapSize) {
        for (int i = heapSize / 2; i >= 1; i--) {
            maxHeapify(array, i, heapSize);
        }
    }

    private void sort(int[] array) {
        int heapSize = array.length;
        buildMaxHeap(array, heapSize);
        for (int i = array.length - 1; i >= 2; i--) {
            int tmp = array[1];
            array[1] = array[i];
            array[i] = tmp;

            maxHeapify(array, 1, --heapSize);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort heapSort = new HeapSort();
//        heapSort.buildMaxHeap(array, array.length);

        heapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
