package tree.q1_traversal;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/2710:15 AM
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }


    public static TreeNode getDefault(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

}
