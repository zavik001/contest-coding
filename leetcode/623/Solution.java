// https://leetcode.com/problems/add-one-row-to-tree/description/

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            // Если глубина равна 1, создаем новый корень
            return new TreeNode(val, root, null);
        }

        // Рекурсивная функция для добавления строки
        addRow(root, val, 1, depth);
        return root;
    }

    private void addRow(TreeNode node, int val, int currentDepth, int targetDepth) {
        if (node == null) {
            return;
        }

        // Если достигли уровня targetDepth - 1
        if (currentDepth == targetDepth - 1) {
            // Создаем новые узлы
            TreeNode newLeft = new TreeNode(val, node.left, null);
            TreeNode newRight = new TreeNode(val, null, node.right);
            node.left = newLeft;
            node.right = newRight;
        } else {
            // Углубляемся в левое и правое поддерево
            addRow(node.left, val, currentDepth + 1, targetDepth);
            addRow(node.right, val, currentDepth + 1, targetDepth);
        }
    }
}
