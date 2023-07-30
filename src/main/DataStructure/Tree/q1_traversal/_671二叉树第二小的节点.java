package DataStructure.Tree.q1_traversal;


// https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
public class _671二叉树第二小的节点 {


    // 求左右子树的最小值
    long a = Long.MAX_VALUE;
    long b = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        dfs(root);
        return b == Long.MAX_VALUE ? -1 : (int) b;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        // 更新最小值
        a = Math.min(a , root.val);

        // 更新第二小的值
        if (a != root.val && root.val - a < b - a) b = root.val;

        dfs(root.left);
        dfs(root.right);
    }



}
