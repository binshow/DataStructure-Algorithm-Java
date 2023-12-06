package DataStructure.Tree.binary_search_tree;


import DataStructure.Tree.TreeNode;

// https://www.yuque.com/binshow/eowsx0/rtcwsltw9lho8zfr#QSt07
public class _230_二叉搜索树中第K个元素 {


    int res = 0;
    int cur = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        dfs(root  , k);
        return res;
    }

    void dfs(TreeNode root , int k){
        if (root == null) return;
        dfs(root.left, k);


        cur++;
        if (cur == k){
            res = root.val;
            return;
        }

        dfs(root.right , k);
    }


}
