package Trees;

// Problem link -
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/

// Problem description -Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

//Example 1:
// Input:  root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input:   root = [1,2,2,null,3,null,3]
// Output: false

/************************* SOLUTION *************************/
// Refer the TreeNode class definition formTreeNode.java file
class Solution {
    public boolean checkSymmetry(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        return (t1.val == t2.val) && checkSymmetry(t1.left, t2.right) && checkSymmetry(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return checkSymmetry(root.left, root.right);
    }
}