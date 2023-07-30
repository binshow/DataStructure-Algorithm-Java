package DataStructure.Tree.q4_tree_build;




import DataStructure.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class _106中序后序构造二叉树 {

    // 中序：左中右
    // 后序：左右中
    Map<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i] , i);
        }
        return dfs(inorder , 0 ,inorder.length-1 , postorder , 0 , postorder.length-1);
    }

    private TreeNode dfs(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int index = map.get(postorder[pe]);
        int lcount = index - is;

        root.left = dfs(inorder , is , index-1 , postorder , ps , ps + lcount -1);
        root.right = dfs(inorder , index+1 , ie , postorder , ps + lcount , pe-1);
        return root;
    }


}
