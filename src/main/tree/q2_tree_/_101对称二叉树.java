package tree.q2_tree_;


// https://leetcode.cn/problems/symmetric-tree/
public class _101对称二叉树 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left , root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val &&  isSym(left.left , right.right) && isSym(left.right , right.left);
    }

}
