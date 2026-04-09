/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        if (curr.next == null) {
            curr.next = head;
            head.next = null;
            return curr;
        }
        ListNode currFur = head.next;
        currFur = currFur.next;
        curr.next = head;
        head.next = null;
        head = curr;

        while (currFur.next != null) {
            curr = currFur;
            currFur = currFur.next;
            curr.next = head;
            head = curr;
        }
        currFur.next = curr;
        return currFur;
    }
}
