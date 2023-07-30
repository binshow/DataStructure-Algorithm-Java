package DataStructure.Tree.q1_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/298:55 AM
 */
public class _103锯齿遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            int n = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (n > 0){
                n--;
                TreeNode cur = queue.poll();
                if (res.size() % 2 == 1) list.addFirst(cur.val);
                else list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}
