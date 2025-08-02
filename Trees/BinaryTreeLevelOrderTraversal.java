package Trees;

// Problem link -
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/

// Problem description -Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Example 1:
// Input: Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input:  root = [1]
// Output: [[1]]

//Example 3:
// Input: root = []
// Output: []

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/************************* SOLUTION *************************/
// Refer the TreeNode class definition formTreeNode.java file
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> subres = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode t = q.poll();
                subres.add(t.val);

                if (t.left != null) {
                    q.add(t.left);
                }

                if (t.right != null) {
                    q.add(t.right);
                }
            }

            res.add(subres);
        }

        return res;
    }
}