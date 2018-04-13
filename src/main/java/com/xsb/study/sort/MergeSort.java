package com.xsb.study.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归并排序
 *
 * @author shibao.xing
 * @since 2018-04-13 19:23
 */
public class MergeSort {

    private void merge(int[] array, int low, int mid, int high) {
        List<Integer> leftList = new ArrayList<>(mid - low + 1);
        List<Integer> rightList = new ArrayList<>(high - mid);

        for (int i = low; i < mid + 1; i++) {
            leftList.add(array[i]);
        }

        for (int i = mid + 1; i < high + 1; i++) {
            rightList.add(array[i]);
        }

        int leftPosition = 0;
        int rightPosition = 0;
        int nowPosition = low;
        while (leftPosition < leftList.size() && rightPosition < rightList.size()) {
            if (leftList.get(leftPosition) < rightList.get(rightPosition)) {
                array[nowPosition++] = leftList.get(leftPosition++);
            } else {
                array[nowPosition++] = rightList.get(rightPosition++);
            }
        }

        while (leftPosition < leftList.size()) {
            array[nowPosition++] = leftList.get(leftPosition++);
        }

        while (rightPosition < rightList.size()) {
            array[nowPosition++] = rightList.get(rightPosition++);
        }
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
