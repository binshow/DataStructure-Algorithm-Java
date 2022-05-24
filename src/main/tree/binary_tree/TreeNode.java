package tree.binary_tree;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/5/2410:12 AM
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
