package Trees;

// Problem link -
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/

// Problem description -Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:
// The left subtree of a node contains only nodes with keys strictly less than the node's key.
// The right subtree of a node contains only nodes with keys strictly greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

//Example 1:
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Input:   root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

/************************* SOLUTION *************************/
// Refer the TreeNode class definition formTreeNode.java file
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null); // initially min and max are set to be null

    }

    public boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}