package DataStructure.Tree.q1_traversal;

import java.util.*;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/binary-DataStructure.tree-level-order-traversal-ii/
 * @date 2023/6/298:55 AM
 */
public class _107层序遍历v2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            while (n > 0 ){
                n--;
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
