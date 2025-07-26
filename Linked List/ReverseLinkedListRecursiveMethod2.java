// Problem link -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/

// Problem description - Given the head of a singly linked list, reverse the
// list, and return the reversed list.
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

/************************* SOLUTION *************************/
// Refer the ListNode class definition form ListNode.java file
class Solution {
    public ListNode reverseRecursive(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;

        return reverseRecursive(next, curr);
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        return reverseRecursive(curr, prev);
    }
}