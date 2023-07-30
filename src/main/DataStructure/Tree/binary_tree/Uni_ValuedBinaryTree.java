package DataStructure.Tree.binary_tree;

/**
 * @author shengbinbin
 * @description: 965: https://leetcode.cn/problems/univalued-binary-tree/
 * @date 2022/5/2410:10 AM
 */
public class Uni_ValuedBinaryTree {

    // 判断是不是单值二叉树
    public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            if (root.left != null && root.val != root.left.val)  return false;
            if (root.right != null && root.val != root.right.val) return false;
            return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}



