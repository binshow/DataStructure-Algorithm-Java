package tree.q3_tree_path;

// https://leetcode.cn/problems/diameter-of-binary-tree/
public class _543二叉树的直径 {

    // 思路： 直径 可以理解为 左子树的最大深度 + 右子树的最大深度
    // 前序遍历，更新 res 即可
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;


        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        res = Math.max(res , l + r - 1);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return res;
    }


    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }




    // 方法二：
    int ans = 0;
    public int diameterOfBinaryTreeV2(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }

    // 返回以 root 为根节点的 子树深度
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        // 更新结果：左子树深度 + 右子树深度
        ans = Math.max(ans , l + r);
        return Math.max(l , r) + 1;
    }

}
