package Trees;

// Problem link -
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/

// Problem description -Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree
// Example 1:
// Input: Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted

// Example 2:
// Input:  nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

/************************* SOLUTION *************************/
// Refer the TreeNode class definition formTreeNode.java file
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}