package com.xsb.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 代码来源： 链接：https://www.jianshu.com/p/89297b012033
 *
 * @author shibao.xing
 * @since 2018-04-21 12:15
 */
public class Question78 {

    public static void main(String[] args) {
        Question78 question78 = new Question78();
        int[] nums = {1, 1, 3};
        List<List<Integer>> subsets = question78.subsets(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
//            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
