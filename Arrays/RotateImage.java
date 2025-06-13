//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/

//Problem description - You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

//Example
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

/************************* SOLUTION *************************/

class Solution {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            for (int i = 0; i < (right - left); i++) {
                int top = left, bottom = right;

                // save top left value
                int temp = matrix[top][left + i];

                // move bottom left to top left
                matrix[top][left + i] = matrix[bottom - i][left];

                // move bottom right to bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // move top right to bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                // assign top left stored value to top right
                matrix[top + i][right] = temp;
            }
            left++;
            right--;
        }

    }
}