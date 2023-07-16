package tree.q3_tree_path;

//https://leetcode.cn/problems/longest-univalue-path/

import tree.TreeNode;

// https://leetcode.cn/problems/longest-univalue-path/solution/by-meteordream-hdy3/
public class _687最长同值路径 {

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root , root.val);
        return res;
    }

    // 以 root 为根节点。最长值为 target 的路径长度
    int dfs(TreeNode root , int target){
        if (root == null) return 0;

        int l =  dfs(root.left , root.val);
        int r =  dfs(root.right , root.val);

        res = Math.max(res , l + r);

        if (root.val != target) return 0;
        else return Math.max(l , r) + 1;
    }
}
