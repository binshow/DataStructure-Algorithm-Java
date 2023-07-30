package DataStructure.Tree.q2_tree_;


import DataStructure.Tree.TreeNode;

// https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
public class _865具有所有最深节点的最小子树 {


    // 最深节点 = 当前节点的左子树高度 = 右子树高度
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (l > r) return subtreeWithAllDeepest(root.left);
        else if (l < r) return subtreeWithAllDeepest(root.right);
        else return root;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left) , getDepth(root.right)) + 1;
    }


}
