package Strings;

// Problem link -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/

// Problem Description - Write a function that reverses a string. The input
// string is given as an array of characters s.
// You must do this by modifying the input array in-place with O(1) extra
// memory.

// Example 1:
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

/************************* SOLUTION *************************/
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }
}