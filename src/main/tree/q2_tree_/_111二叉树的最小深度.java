package tree.q2_tree_;


//https://leetcode.cn/problems/maximum-depth-of-binary-tree/

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111二叉树的最小深度 {

    // 递归实现
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left) , minDepth(root.right)) + 1;
    }



    // 层序遍历实现
    public int minDepthV2(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 1;
        while (queue.size() > 0){
            int n = queue.size();
            while (n > 0){
                TreeNode cur = queue.poll();
                n--;
                if (cur.left == null && cur.right == null) return res;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res++;
        }
        return res;
    }
}
