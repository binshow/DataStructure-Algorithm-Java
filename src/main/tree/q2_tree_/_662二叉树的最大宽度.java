package tree.q2_tree_;


// https://leetcode.cn/problems/maximum-width-of-binary-tree/

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _662二叉树的最大宽度 {

    // 思路：借助层序遍历，添加一个 index 数组
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer>  indexQ = new LinkedList<>();
        queue.add(root);
        indexQ.add(0);
        int res = 1;
        while (queue.size() > 0){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            while (n > 0){
                n--;
                TreeNode cur = queue.poll();
                int index = indexQ.poll();
                list.add(index);
                if (cur.left != null){
                    queue.add(cur.left);
                    indexQ.add(index * 2 + 1);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    indexQ.add(index * 2 + 2);
                }
            }
            res = Math.max(res ,list.get(list.size()-1) - list.get(0) + 1);
        }
        return res;
    }
}
