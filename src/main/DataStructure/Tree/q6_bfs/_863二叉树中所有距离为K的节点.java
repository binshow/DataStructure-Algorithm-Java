package DataStructure.Tree.q6_bfs;


//https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/


import java.util.*;


public class _863二叉树中所有距离为K的节点 {


    // 二叉树中节点的方向 只有 左子树、右子树、父节点 三个方向搜索即可

    Map<TreeNode , TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //1. 将二叉树中的所有节点的父节点都塞入到map中
        dfs(root , null);

        //2. 从target开始搜索所以距离为k的节点，递归实现
            // 需要使用set去重!!!
        searchK(target , k);
        return res;
    }



    // 将二叉树中的所有节点的父节点都塞入到map中
    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        map.put(root , parent);
        dfs(root.left , root );
        dfs(root.right , root);
    }

    private void searchK(TreeNode root, int k) {
        if (root == null || set.contains(root)) return;
        set.add(root);
        // 加入结果集
        if (k == 0){
            res.add(root.val);
            return;
        }

        // 递归从三个方向搜索
        searchK(root.left , k-1);
        searchK(root.right , k-1);
        searchK(map.get(root) , k-1);
    }

}
