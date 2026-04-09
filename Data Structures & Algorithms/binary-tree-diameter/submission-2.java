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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return maxDiameter;
    }

    private int diameterOfBinaryTreeHelper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int left = diameterOfBinaryTreeHelper(curr.left);
        int right = diameterOfBinaryTreeHelper(curr.right);
        maxDiameter = Math.max(maxDiameter, left + right);

        return 1 + Math.max(left, right);
    }
}
