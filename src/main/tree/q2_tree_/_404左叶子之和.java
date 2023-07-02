package tree.q2_tree_;

// https://leetcode.cn/problems/sum-of-left-leaves/
public class _404左叶子之和 {

    // 递归实现
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root ){
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }



    // 层序遍历实现
}
