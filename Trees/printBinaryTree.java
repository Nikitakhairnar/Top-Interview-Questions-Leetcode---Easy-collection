package Trees;

//Problem link - https://leetcode.com/problems/print-binary-tree/description/

//Problem description - Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:
// The height of the tree is height and the number of rows m should be equal to height + 1.
// The number of columns n should be equal to 2height+1 - 1.
// Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
// For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
// Continue this process until all the nodes in the tree have been placed.
// Any empty cells should contain the empty string "".
// Return the constructed matrix res.

// Input: root = [1,2]
// Output: 
// [["","1",""],
//  ["2","",""]]

// Input: root = [1,2,3,null,4]
// Output: 
// [["","","","1","","",""],
//  ["","2","","","","3",""],
//  ["","","4","","","",""]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/************************* SOLUTION *************************/

class Solution {
    public int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(calculateHeight(root.left), calculateHeight(root.right)) + 1;
    }

    public void fillAnswer(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;

        res[i][(l + r) / 2] = "" + root.val;
        fillAnswer(res, root.left, i + 1, l, (l + r) / 2);
        fillAnswer(res, root.right, i + 1, (l + r + 1) / 2, r);
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = calculateHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        List<List<String>> ans = new ArrayList<>();
        fillAnswer(res, root, 0, 0, res[0].length);

        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }

        return ans;
    }
}