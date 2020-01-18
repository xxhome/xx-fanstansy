package com.fantasy.xxtest.leetcode;

import com.fantasy.xxtest.base.BaseTest;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class LeetCode001 extends BaseTest {

    // 给定 nums = [2, 7, 11, 15], target = 9
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for(int i = 0; i < nums.length; i++){
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void testTwoSum(){
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        logger.info("result:{}", ints);
    }
}
