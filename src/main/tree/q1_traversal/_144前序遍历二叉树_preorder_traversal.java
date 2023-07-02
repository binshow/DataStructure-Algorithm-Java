package tree.q1_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/2810:00 AM
 */
public class _144前序遍历二叉树_preorder_traversal {


    //   1
    // 2  3
    //4 5
    // preorder： 中左右  1 2 4 5 3
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0){
            TreeNode cur = stack.pop();
            list.add(cur.val);

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return list;
    }
}
