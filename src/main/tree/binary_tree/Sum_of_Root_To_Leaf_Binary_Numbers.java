package tree.binary_tree;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 * @date 2022/5/3011:24 PM
 */
public class Sum_of_Root_To_Leaf_Binary_Numbers {

    //      1
    //  0      1
    // 0  1   0   1
    // res = (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int preSum) {
        if (root == null) return;
        preSum = preSum * 2 + root.val;
        if (root.left == null && root.right == null) {  // 每次到叶子节点的时候，就说明这条路径走完了。用res 加上当前值
            res += preSum;
        }
        dfs(root.left, preSum);
        dfs(root.right, preSum);
    }
}
