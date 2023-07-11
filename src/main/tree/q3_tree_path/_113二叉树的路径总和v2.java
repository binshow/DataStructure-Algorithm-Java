package tree.q3_tree_path;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/path-sum/
public class _113二叉树的路径总和v2 {


    // 从 root 节点 到 叶子节点 是否存在 和 = target 的路径
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root , new ArrayList<>() , targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list , int targetSum) {
        //1. 先将当前节点加入到路径中
        list.add(root.val);
        targetSum -= root.val;

        //2. 如果已经到叶子节点，且满足条件了，加入到结果集中
        if (root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        //3. 前序遍历，记得回溯！！！
        if (root.left != null){
            dfs(root.left , list , targetSum);
            list.remove(list.size()-1);
        }

        if (root.right != null){
            dfs(root.right , list , targetSum);
            list.remove(list.size()-1);
        }

    }

}
