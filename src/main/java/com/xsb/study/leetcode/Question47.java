package com.xsb.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shibao.xing
 * @since 2018-04-21 11:16
 */
public class Question47 {

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = question47.permuteUnique(nums);
        System.out.println(list);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> sets = new HashSet<>();
        Arrays.sort(nums);
        permuteRecursion(nums, 0, nums.length - 1, sets);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(sets);
        return result;
    }

    private void permuteRecursion(int[] nums, int start, int end, Set<List<Integer>> sets) {
        if (start == end) {
            List<Integer> tmpList = new ArrayList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            sets.add(tmpList);
            return;
        }

        for (int i = start; i <= end; i++) {
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            permuteRecursion(nums, start + 1, end, sets);
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
        }
    }
}
