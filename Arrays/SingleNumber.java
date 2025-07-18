
//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/

//Problem description - Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

/************************* SOLUTION *************************/

class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }
}