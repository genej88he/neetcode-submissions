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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> eachLayer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode removed = q.remove();
                eachLayer.add(removed.val);
                if (removed.left != null) {
                    q.add(removed.left);
                }

                if (removed.right != null) {
                    q.add(removed.right);
                }
            }
            result.add(eachLayer);
        }
        return result;
    }
}
