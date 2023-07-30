package DataStructure.Tree.binary_search_tree;

import DataStructure.Tree.TreeNode;

public class _700_701二叉搜索树的搜索_插入 {

    //https://leetcode.cn/problems/search-in-a-binary-search-tree/
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) return searchBST(root.right , val);
        else if (root.val > val) return searchBST(root.left , val);
        return root;
    }

    // 迭代版
    public TreeNode searchBSTV2(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode cur = root;
        while (cur != null){
            if (cur.val < val) cur = cur.right;
            else if (cur.val > val) cur = cur.left;
            else return cur;
        }
        return null;
    }




    // https://leetcode.cn/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.left = insertIntoBST(root.left , val);
        else root.right = insertIntoBST(root.right , val);
        return root;
    }


    // 迭代版
    public TreeNode insertIntoBSTV2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null){
            parent = cur;
            cur = cur.val < val ? cur.right : cur.left;
        }

        if (parent.val < val) parent.right = new TreeNode(val);
        else parent.left = new TreeNode(val);
        return root;
    }
}
