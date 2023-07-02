package tree.q2_tree_;

// https://leetcode.cn/problems/subtree-of-another-tree/
public class _572判断子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        return isSame(root , subRoot) || isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isSame(a.left , b.left) && isSame(a.right , b.right);
    }

}
