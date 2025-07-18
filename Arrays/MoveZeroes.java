//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/

//Problem Description - Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

/************************* SOLUTION *************************/

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int z = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[z];
                nums[z] = temp;
                z++;
            }
        }
    }
}