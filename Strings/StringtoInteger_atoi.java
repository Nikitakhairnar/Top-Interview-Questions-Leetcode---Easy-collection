package Strings;

// Problem link
// -https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/

// Problem description - 
// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
// The algorithm for myAtoi(string s) is as follows:
// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Return the integer as the final result. 

// Example 1:
// Input: s = "42"
// Output: 42
// Explanation:
// The underlined characters are what is read in and the caret is the current reader position.
// Step 1: "42" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "42" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "42" ("42" is read in)
//            ^
// Example 2:
// Input: s = " -042"
// Output: -42
// Explanation:
// Step 1: "   -042" (leading whitespace is read and ignored)
//             ^
// Step 2: "   -042" ('-' is read, so the result should be negative)
//              ^
// Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//                ^
// Example 3:
// Input: s = "1337c0d3"
// Output: 1337
// Explanation:
// Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//              ^
// Example 4:
// Input: s = "0-1"
// Output: 0
// Explanation:
// Step 1: "0-1" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//           ^
// Example 5:
// Input: s = "words and 987"
// Output: 0
// Explanation:

// Reading stops at the first non-digit character 'w'.

/************************* SOLUTION *************************/

class Solution {
    public int myAtoi(String s) {
        char[] characters = s.toCharArray();
        Integer result = null;
        boolean isPositive = true, wasPositive = true, isSignPossible = true;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                if (result == null && isSignPossible) {
                    continue;
                } else
                    break;
            } else if (characters[i] >= '0' && characters[i] <= '9') {
                int newDigit = characters[i] - '0';
                int oldValue = result == null ? 0 : result;

                if (result == null) {
                    if (newDigit == 0) {
                        isSignPossible = false;
                        continue;
                    }
                    result = isPositive ? newDigit : -newDigit;
                } else {
                    result *= 10;
                    result = isPositive ? result + newDigit : result - newDigit;
                }
                isSignPossible = false;

                // If the old value divided by 10 does not equal to the new value, it is an
                // Overflow or an Underflow!
                if (result / 10 != oldValue) {
                    return wasPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else if (characters[i] == '-') {
                if (result == null && isSignPossible) {
                    isPositive = false;
                    wasPositive = false;
                    isSignPossible = false;
                } else
                    break;
            } else if (characters[i] == '+' && isSignPossible) {
                if (result == null) {
                    isPositive = true;
                    wasPositive = true;
                    isSignPossible = false;
                } else
                    break;
            } else
                break;
        }

        if (result == null) {
            result = 0;
        }

        return result;
    }
}
