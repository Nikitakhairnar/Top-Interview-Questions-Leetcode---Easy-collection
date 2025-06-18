package Arrays;

//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/

//Problem Description -Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.HashMap;

/************************* SOLUTION *************************/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int d = target - nums[i];
            if (mp.containsKey(d)) {
                ans[0] = i;
                ans[1] = mp.get(d);
                return ans;
            }
            mp.put(nums[i], i);
        }

        return ans;
    }
}