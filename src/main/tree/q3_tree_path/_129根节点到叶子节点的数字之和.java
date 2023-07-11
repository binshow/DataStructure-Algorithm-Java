package tree.q3_tree_path;

// https://leetcode.cn/problems/sum-root-to-leaf-numbers/
public class _129根节点到叶子节点的数字之和 {

    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root , 0);
        return res;
    }

    void dfs(TreeNode root , int sum){
        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null){
            System.out.println(sum);
            res += sum;
            return;
        }

        if (root.left != null){
            dfs(root.left , sum);
        }

        if (root.right != null){
            dfs(root.right , sum);
        }
    }
}
