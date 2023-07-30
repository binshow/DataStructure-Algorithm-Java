package DataStructure.Tree.q1_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/298:56 AM
 */
public class _199二叉树右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            int n = queue.size();
            while (n > 0){
                TreeNode cur = queue.poll();
                n--;
                if (n == 0) res.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return res;
    }
}
