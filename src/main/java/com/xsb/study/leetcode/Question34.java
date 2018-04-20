package com.xsb.study.leetcode;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2018-04-19 20:39
 */
public class Question34 {

    public static void main(String[] args) {
        int[] nums = {5};
        Question34 question34 = new Question34();
        int[] ints = question34.searchRange(nums, 6);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int min = searchMin(nums, start, end, target);
        int max = searchMax(nums, start, end, target);
        if (min == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        } else {
            return new int[] {min, max};
        }
    }

    public int searchMin(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return Integer.MAX_VALUE;
        }

        if (nums[mid] == target) {
            return Math.min(searchMin(nums, start, mid - 1, target), mid);
        } else if (nums[mid] > target) {
            return searchMin(nums, start, mid - 1, target);
        } else {
            return searchMin(nums, mid + 1, end, target);
        }
    }

    public int searchMax(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        if (nums[mid] == target) {
            return Math.max(searchMax(nums, mid + 1, end, target), mid);
        } else if (nums[mid] > target) {
            return searchMax(nums, start, mid - 1, target);
        } else {
            return searchMax(nums, mid + 1, end, target);
        }
    }
}
