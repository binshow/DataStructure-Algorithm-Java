package DataStructure.Tree.q2_tree_;


import DataStructure.Tree.TreeNode;

//https://leetcode.cn/problems/invert-binary-tree/
public class _226翻转二叉树 {

    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
