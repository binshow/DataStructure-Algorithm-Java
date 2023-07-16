package tree.q4_tree_build;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class _105前序中序构造二叉树 {

    // 前序： 中左右
    // 中序： 左中右
    Map<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i] , i);
        }
        return dfs(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) return null;
        TreeNode root = new TreeNode(preorder[pl]);

        int index = map.get(preorder[pl]);
        int lcount = index - il;  // 左子树个数
        root.left = dfs(preorder , pl + 1 , pl+1 + lcount-1 , inorder , il , index-1);
        root.right = dfs(preorder , pl+ lcount + 1, pr , inorder , index+1 , ir);
        return root;
    }
}
