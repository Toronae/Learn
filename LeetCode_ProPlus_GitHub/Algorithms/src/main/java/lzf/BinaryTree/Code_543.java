package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
         int left  = maxDepth(root.left);
         int right  = maxDepth(root.right);
         if (max < left + right) {
             max = right +left;
         }
        //节点深度
         return Math.max(right,left) + 1;
    }
}
