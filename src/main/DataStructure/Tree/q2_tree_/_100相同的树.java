package DataStructure.Tree.q2_tree_;


//https://leetcode.cn/problems/same-tree/

import DataStructure.Tree.TreeNode;

public class _100相同的树 {


    // 递归实现
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left  , q.left) && isSameTree(p.right , q.right);
    }







}
