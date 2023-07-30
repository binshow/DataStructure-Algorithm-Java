package DataStructure.Tree.q2_tree_;

import DataStructure.Tree.TreeNode;

//https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
public class _865所有最深节点的最小子树 {

    // 一个节点的 左子树深度 == 右子树深度，则说明找到了 当前节点
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(l == r) return root;
        else if(l < r) return subtreeWithAllDeepest(root.right);
        else return subtreeWithAllDeepest(root.left);
    }


    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

}
