// Problem link -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/

// Problem description - Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

/************************* SOLUTION *************************/
// Refer the ListNode class definition form ListNode.java file
class Solution {
    // Divide the linked list in two equal parts
    // The algorithm works such that first half is reversed and second half stays
    // similar to original half
    // then traverse both halves and compare values one by one
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }
}
