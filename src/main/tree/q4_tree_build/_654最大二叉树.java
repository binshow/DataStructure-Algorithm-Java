package tree.q4_tree_build;

// https://leetcode.cn/problems/maximum-binary-tree/

import tree.TreeNode;

public class _654最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildTree(nums , 0 , nums.length-1);

    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int max = nums[l];
        int index = l;
        for (int i = l; i <= r; i++) {
           if (nums[i] > max){
               max = nums[i];
               index = i;
           }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums , l  , index-1);
        root.right = buildTree(nums , index+1 , r);
        return root;
    }

}
