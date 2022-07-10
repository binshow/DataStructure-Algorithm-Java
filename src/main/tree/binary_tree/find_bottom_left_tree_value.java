package tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @date 2022/6/2210:19 PM
 */
public class find_bottom_left_tree_value {

    // 找树的最深最左子节点
    public int findBottomLeftValue(TreeNode root) {
        // 思路：层序遍历，从右到左放入队列中
        if (root == null) return -1;
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode cur = root;
        while (list.size() != 0){
            cur = list.poll();
            if (cur.right != null) list.add(cur.right);
            if (cur.left != null) list.add(cur.left);
        }
        return cur.val;
    }
}
