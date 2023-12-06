package DataStructure.Tree.binary_search_tree;


import DataStructure.Tree.TreeNode;

// https://leetcode.cn/problems/recover-binary-search-tree/
public class _99_恢复二叉搜索树 {






    /*
    * 有两种错误的交换方式：
    * 1. 相邻两个交换了
    * 2. 非相邻两个交换，
    *
    * 两者相同点都是  遇到逆序对时，前面一次取 pre ，后面一次取当前节点
    * https://leetcode.cn/problems/recover-binary-search-tree/solutions/365622/tu-jie-hui-fu-yi-ge-er-cha-sou-suo-shu-by-hyj8/
    *
    *
    *
    * */

    TreeNode pre;
    TreeNode x , y ;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        // 中序遍历
        dfs(root);

        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if(pre == null) pre = root;
        else {
            //3,6,9,10,14  如果是14和6交换(非相邻节点交换)：3,14,9,10,6  判断出现非递增的情况 第一个节点应该是更大的那个
            // 6,3,9,10,14 如果是相邻节点交换，同理
            if (pre.val >= root.val && x == null) x = pre;   // 记录pre
            if (pre.val >= root.val && x != null) y = root;  // 记录root
            pre = root;
        }
        dfs(root.right);
    }

}
