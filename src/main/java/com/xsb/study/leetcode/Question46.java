package com.xsb.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2018-04-21 10:44
 */
public class Question46 {

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        int[] nums = {1, 2};
        List<List<Integer>> list = question46.permute(nums);
        System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permuteRecursion(nums, 0, nums.length - 1, lists);
        return lists;
    }

    private void permuteRecursion(int[] nums, int start, int end, List<List<Integer>> list) {
        if (start == end) {
            List<Integer> tmpList = new ArrayList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            list.add(tmpList);
            return;
        }

        for (int i = start; i <= end; i++) {
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            permuteRecursion(nums, start + 1, end, list);
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
        }
    }
}
