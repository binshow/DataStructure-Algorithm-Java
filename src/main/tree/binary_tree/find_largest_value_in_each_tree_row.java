package tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * @date 2022/6/249:25 AM
 */
public class find_largest_value_in_each_tree_row {

    // 思路:层序遍历，每一层保存最大的值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = root;
        while (queue.size() != 0){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0){
                cur = queue.poll();
                size--;
                max = Math.max(max , cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }

}
