package tree.q2_tree_;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
public class _236二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p == null || q == null) return p == null ? q : p;

        TreeNode l = lowestCommonAncestor(root.left , p , q);
        TreeNode r = lowestCommonAncestor(root.right , p , q);
        if (l == null) return r;
        if (r == null)  return l;
        return root;
    }

}
