package Strings;

//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

//Problem Description - Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:
// Input: x = -123
// Output: -321

/************************* SOLUTION *************************/
class Solution {
    public int reverse(int x) {
        long finalNum = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            finalNum += lastDigit;
            finalNum = finalNum * 10;
            x = x / 10;
        }
        finalNum = finalNum / 10;
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return (int) (-1 * finalNum);
        }
        return (int) finalNum;
    }
}