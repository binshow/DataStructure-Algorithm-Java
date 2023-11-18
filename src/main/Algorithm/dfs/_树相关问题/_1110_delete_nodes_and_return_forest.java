package Algorithm.dfs._树相关问题;

//https://leetcode.cn/problems/delete-nodes-and-return-forest/

import DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1110_delete_nodes_and_return_forest {


    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        for(int num : to_delete) set.add(num);
        if(dfs(root , res) != null) res.add(root);
        return res;
    }

    // 返回以 root 为根的子树中，删除所有需要删除的节点后的树的根节点
    // 后序遍历：因为要先 解决子树，才能解决当前节点
    TreeNode dfs(TreeNode root , List<TreeNode> res){
        if(root == null) return null;
        root.left = dfs(root.left , res);
        root.right = dfs(root.right , res);

        //case1: 当前节点无需被删除, 直接返回给上一层
        if(!set.contains(root.val)) return root;

        //case 2: 当前节点需要被删除, res记录左右节点, 并返回null给上一层
        if(root.left != null) res.add(root.left);
        if(root.right != null) res.add(root.right);
        return null;
    }


}
