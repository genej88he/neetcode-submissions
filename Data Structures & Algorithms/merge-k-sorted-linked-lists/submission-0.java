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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode each : lists) {
            if (each != null) {
                minHeap.add(each);
            }
        }

        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(!minHeap.isEmpty()) {
            ListNode ind = minHeap.remove();
            curr.next = ind;
            curr = curr.next;

            if (ind.next != null) {
                minHeap.add(ind.next);
            }
        }

        return result.next;
    }
}
