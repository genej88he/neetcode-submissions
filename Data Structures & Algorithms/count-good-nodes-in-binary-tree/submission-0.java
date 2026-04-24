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
    public int goodNodes(TreeNode root) {
        List<Integer> prevNodes = new ArrayList<>();
        return goodNodes(root, prevNodes);
    }

    private int goodNodes(TreeNode curr, List<Integer> prevNodes) {
        if (curr == null) {
            return 0;
        } else {
            boolean check = true;
            int size = prevNodes.size();
            for (int i = 0; i < size; i++) {
                System.out.print(prevNodes.get(i));
                if (prevNodes.get(i) > curr.val) {
                    check = false;
                }
            }
            prevNodes.add(curr.val);
            int left = goodNodes(curr.left, prevNodes);
            int right = goodNodes(curr.right, prevNodes);
            prevNodes.remove(prevNodes.size() - 1);
            if (check) {
                return 1 + left + right;
            }
            return left + right;

        }
    }
}
