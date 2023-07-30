package DataStructure.Tree.q3_tree_path;

//https://leetcode.cn/problems/binary-tree-maximum-path-sum/

//https://www.bilibili.com/video/BV17o4y187h1/?vd_source=8f74d600ef0b2504fc0d4190400470aa

import DataStructure.Tree.TreeNode;

public class _124二叉树的最大路径和 {

    // 思路： 左子树的最大路径和 + 右子树的最大路径和

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    // 以当前节点为根节点的最大路径和
    int dfs(TreeNode root){
        if (root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        res = Math.max(res , l + r + root.val);

        return Math.max(Math.max(l, r) + root.val, 0);

    }

}
