/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        addToMinHeap(root, minHeap);
        int removed = -1;
        for (int i = 0; i < k; i++) {
            removed = minHeap.remove().val;
        }
        return removed;
    }

    private void addToMinHeap(TreeNode curr, PriorityQueue<TreeNode> minHeap) {
        if (curr != null) {
            minHeap.add(curr);
            addToMinHeap(curr.left, minHeap);
            addToMinHeap(curr.right, minHeap);
        }
    }
}
