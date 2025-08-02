package Trees;

// Problem link -
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/

// Problem description - Given the root of a binary tree, return its maximum depth. 
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Example 2:
// Input:  root = [1,null,2]
// Output: 2

/************************* SOLUTION *************************/
// Refer the TreeNode class definition formTreeNode.java file
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLen = maxDepth(root.left) + 1;
        int rightLen = maxDepth(root.right) + 1;

        if (leftLen > rightLen) {
            return leftLen;
        }

        return rightLen;

    }
}