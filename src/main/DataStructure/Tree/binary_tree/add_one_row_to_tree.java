package DataStructure.Tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/add-one-row-to-DataStructure.tree/
 * @date 2022/8/510:10 AM
 */
public class add_one_row_to_tree {

    // https://leetcode.cn/problems/add-one-row-to-tree/
    // 解法1：层序遍历 BFS 时间复杂度 On, 空间复杂度 On
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val , root , null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1; // root 节点为第一层
        while (queue.size() > 0){
            int size = queue.size();
            while (size > 0){
                size--;
                TreeNode curNode = queue.poll();
                if (cur == depth - 1){
                    // 开始加节点
                    TreeNode a = new TreeNode(val);
                    TreeNode b = new TreeNode(val);
                    a.left = curNode.left;
                    b.right = curNode.right;
                    curNode.left = a;
                    curNode.right = b;
                }else {
                    if (curNode.left != null) queue.add(curNode.left);
                    if (curNode.right != null) queue.add(curNode.right);
                }
            }
            cur++;
        }
        return root;
    }



}
