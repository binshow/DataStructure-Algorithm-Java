package DataStructure.Tree.binary_search_tree;

import DataStructure.Tree.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class _98验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root.left , Long.MIN_VALUE , root.val) && isValid(root.right , root.val , Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max ) return false;
        return isValid(root.left , min , root.val) && isValid(root.right , root.val , max);
    }

}
