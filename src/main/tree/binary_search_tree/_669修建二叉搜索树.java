package tree.binary_search_tree;

import tree.TreeNode;

public class _669修建二叉搜索树 {

    // https://leetcode.cn/problems/trim-a-binary-search-tree/
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right , low , high);
        if (root.val > high) return trimBST(root.left , low , high);

        root.left = trimBST(root.left , low , root.val);
        root.right = trimBST(root.right , root.val , high);
        return root;
    }


    // 迭代版
    public TreeNode trimBSTV2(TreeNode root, int low, int high) {
        if (root == null) return null;
//        TreeNode parent = root;
//        TreeNode cur = root;
//        while (cur != null){
//            if (cur.left !=)
//        }
        return root;
    }


}
