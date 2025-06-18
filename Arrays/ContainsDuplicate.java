package Arrays;

//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

//Problem Description - Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Example 1:

// Input: nums = [1,2,3,1]

// Output: true

// Explanation:

// The element 1 occurs at the indices 0 and 3.

import java.util.Arrays;

/************************* SOLUTION *************************/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}