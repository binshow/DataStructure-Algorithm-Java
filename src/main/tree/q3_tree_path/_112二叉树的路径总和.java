package tree.q3_tree_path;

//https://leetcode.cn/problems/path-sum/
public class _112二叉树的路径总和 {


    // 从 root 节点 到 叶子节点 是否存在 和 = target 的路径
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left , targetSum - root.val) || hasPathSum(root.right , targetSum - root.val);
    }

}
