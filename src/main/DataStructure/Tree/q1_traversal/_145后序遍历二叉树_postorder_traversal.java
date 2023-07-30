package DataStructure.Tree.q1_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/2810:00 AM
 */
public class _145后序遍历二叉树_postorder_traversal {


    //   1
    // 2  3
    //4 5
    // preorder： 中左右  1 2 4 5 3
    // postorder  左右中  4 5 2 3 1   可以 中右左  倒过来
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        Collections.reverse(res);
        return res;
    }
}
