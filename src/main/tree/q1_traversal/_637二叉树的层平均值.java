package tree.q1_traversal;


// https://leetcode.cn/problems/average-of-levels-in-binary-tree/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            int n = queue.size();
            double sum = 0;
            int size = queue.size();
            while (n > 0){
                n--;
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            res.add(sum / size);
        }
        return res;
    }
}
