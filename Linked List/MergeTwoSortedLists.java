// Problem link -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/

// Problem description -You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.

// Example 1:
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

//Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]

/************************* SOLUTION *************************/
// Refer the ListNode class definition form ListNode.java file
class Solution {
    // No extra space required, does merge in-place
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode tail = null;
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        if (list1.val <= list2.val) {
            head = list1;
            tail = list1;
            curr1 = curr1.next;
        } else {
            head = list2;
            tail = list2;
            curr2 = curr2.next;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                tail.next = curr1;
                curr1 = curr1.next;
                tail = tail.next;
            } else {
                tail.next = curr2;
                curr2 = curr2.next;
                tail = tail.next;
            }
        }

        if (curr1 == null) {
            tail.next = curr2;
        } else {
            tail.next = curr1;
        }

        return head;

    }
}