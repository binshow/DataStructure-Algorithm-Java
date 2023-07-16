package tree.q3_tree_path;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-paths/
public class _257二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> path = new ArrayList<>();
        dfs(root , path , res);
        return res;
    }

    void dfs(TreeNode root , List<TreeNode> path , List<String> res){
        path.add(root);
        if (root.left == null && root.right == null){
           StringBuilder sb = new StringBuilder();
           for (TreeNode node : path) sb.append(node.val).append("->");
           sb.deleteCharAt(sb.length()-1);
           sb.deleteCharAt(sb.length()-1);
           res.add(new String(sb));
           return;
        }

        if (root.left != null){
            dfs(root.left , path , res);
            path.remove(path.size()-1);
        }

        if (root.right != null){
            dfs(root.right , path , res);
            path.remove(path.size()-1);
        }
    }

}
