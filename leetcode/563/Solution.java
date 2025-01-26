// https://leetcode.com/problems/binary-tree-tilt/description/

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
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return totalTilt;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = traverse(node.left);
        int rightSum = traverse(node.right);

        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        return node.val + leftSum + rightSum;
    }
}
