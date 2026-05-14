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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pSeen = new ArrayList<>();
        List<TreeNode> qSeen = new ArrayList<>();
        dfs(root, p, pSeen);
        dfs(root, q, qSeen);

        TreeNode result = null;
        for (int i = pSeen.size() - 1; i >= 0; i--) {
            if (qSeen.contains(pSeen.get(i))) {
                result = pSeen.get(i);
                break;
            }
            
        }
        return result;
    }

    private void dfs(TreeNode curr, TreeNode p, List<TreeNode> seen) {
        if (curr.val == p.val || curr == null) {
            seen.add(curr);
            return;
        }
        seen.add(curr);

        if (p.val < curr.val) {
            dfs(curr.left, p, seen);
        } else {
            dfs(curr.right, p, seen);
        } 
    }
}
