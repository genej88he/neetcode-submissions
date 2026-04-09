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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode mostRight = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node != null) {
                    mostRight = node;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (mostRight != null) {
                list.add(mostRight.val);
            }
        }
        return list;
    }
}
