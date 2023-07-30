package DataStructure.Tree.binary_search_tree;

import DataStructure.Tree.TreeNode;

// https://leetcode.cn/tag/array/problemset/
public class _108有序数组转换为BST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildTree(nums , 0 , nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + r >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums , l , mid-1);
        root.right = buildTree(nums , mid+1 , r);
        return root;
    }

}
