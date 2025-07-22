package Strings;

// Problem link -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/

// Problem description -Given two strings needle and haystack, return the index
// of the first occurrence of needle in haystack, or -1 if needle is not part of
// haystack.

// Example 1:
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.

// Example 2:
// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.

/************************* SOLUTION *************************/

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= m - n; i++) {
            String s = haystack.substring(i, i + n);
            if (s.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
