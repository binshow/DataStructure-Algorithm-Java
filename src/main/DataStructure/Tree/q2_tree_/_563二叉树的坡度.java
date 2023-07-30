package DataStructure.Tree.q2_tree_;

import DataStructure.Tree.TreeNode;

// https://leetcode.cn/problems/binary-tree-tilt/
public class _563二叉树的坡度 {

    int res = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;

        res += Math.abs(treeSum(root.left) - treeSum(root.right));

        findTilt(root.left);
        findTilt(root.right);

        return res;
    }



    private int treeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + treeSum(root.left) + treeSum(root.right);
    }


}
