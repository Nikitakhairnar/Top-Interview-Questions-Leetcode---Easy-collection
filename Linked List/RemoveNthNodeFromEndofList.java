// Problem link -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/

// Problem description - Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

/************************* SOLUTION *************************/
// Refer the ListNode class definition form ListNode.java file
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        if (head.next == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int m = len - n - 1;
        if (m == -1) {
            return head.next;
        }

        curr = head;
        while (m > 0) {
            curr = curr.next;
            m--;
        }

        if (curr.next == null) {
            return null;
        }

        curr.next = curr.next.next;
        return head;
    }
}