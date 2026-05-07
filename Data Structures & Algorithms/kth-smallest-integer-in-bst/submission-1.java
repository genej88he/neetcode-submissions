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
    public int count = 0;
    public int result = -1;
    public int kthSmallest(TreeNode root, int k) {

        inOrderTraversal(root, k);
        return result;
    }
    
    private void inOrderTraversal(TreeNode curr, int k) {
        if (curr != null && count <= k) {
            inOrderTraversal(curr.left, k);
            count++;
            if (count == k) {
                result = curr.val;
                return;
            }
            inOrderTraversal(curr.right, k);
        } 
        
    }
    
}
