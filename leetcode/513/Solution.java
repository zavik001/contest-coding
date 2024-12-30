// https://leetcode.com/problems/find-bottom-left-tree-value/description/

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
    private int maxDepth = -1;
    private int bottomLeftValue = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return bottomLeftValue;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}