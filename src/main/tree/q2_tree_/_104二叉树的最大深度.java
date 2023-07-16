package tree.q2_tree_;


//https://leetcode.cn/problems/maximum-depth-of-binary-tree/

import tree.TreeNode;

public class _104二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }
}
