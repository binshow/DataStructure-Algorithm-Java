package tree.q2_tree_;


import tree.TreeNode;

// https://leetcode.cn/problems/leaf-similar-trees/
public class _872叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        return getLeafNode(root1 , "").equals(getLeafNode(root2 , ""));

    }


    private String getLeafNode(TreeNode root , String s){
        if (root == null) return s;
        if (root.left == null && root.right == null){
            s = s + root.val + ",";
            return s;
        }
        return getLeafNode(root.left , s) + getLeafNode(root.right , s);
    }

    public static void main(String[] args) {



    }


}
