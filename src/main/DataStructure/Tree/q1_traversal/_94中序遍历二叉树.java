package DataStructure.Tree.q1_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/2710:15 AM
 */
public class _94中序遍历二叉树 {


    // 中序遍历： 左中右

    //  1
    // 2 3
   // 4 5
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }



}
