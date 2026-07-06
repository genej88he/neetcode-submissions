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
    public void reorderList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode rightHalf = slow.next;
            slow.next = null;
            ListNode prev = null;
            while (rightHalf != null) {
                ListNode temp = rightHalf.next;
                rightHalf.next = prev;
                prev = rightHalf;
                rightHalf = temp;
            }

            rightHalf = prev;
            ListNode leftHalf = head;
            while (rightHalf != null) {
                ListNode leftTemp = leftHalf.next;
                ListNode rightTemp = rightHalf.next;
                leftHalf.next = rightHalf;
                rightHalf.next = leftTemp;
                leftHalf = leftTemp;
                rightHalf = rightTemp;
            }
        }
        
    
}

