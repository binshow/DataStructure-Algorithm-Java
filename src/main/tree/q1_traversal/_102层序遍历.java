package tree.q1_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/298:54 AM
 */
public class _102层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            while (n > 0){
                n--;
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}
