package tree.q2_tree_;

// https://leetcode.cn/problems/binary-tree-pruning/
public class _814二叉树剪枝 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        // 为啥一定要 先删子节点，最后再删根节点
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // base case 删除叶子节点为0 的
        if (root.left == null && root.right == null && root.val == 0) return null;

        return root;


    }
}
