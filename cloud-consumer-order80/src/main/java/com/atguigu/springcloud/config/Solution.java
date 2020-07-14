package com.atguigu.springcloud.config;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
            int num = target - nums[i];
            if (hashMap.containsKey(num) && hashMap.get(num) != i) {
                return new int[]{hashMap.get(num), i};
            }
        }
        return null;
    }
}