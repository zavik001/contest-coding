// https://leetcode.com/problems/construct-string-from-binary-tree/description/

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
    public String tree2str(TreeNode root) {
        return dfs(root);
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        res.append(root.val);

        if (root.left != null || root.right != null) {
            res.append("(").append(dfs(root.left)).append(")");
        }

        if (root.right != null) {
            res.append("(").append(dfs(root.right)).append(")");
        }

        return res.toString();
    }
}
