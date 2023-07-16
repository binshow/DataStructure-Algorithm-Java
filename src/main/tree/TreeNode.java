package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/2710:15 AM
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

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



    public static List<List<String>> printTree(TreeNode root){
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int depth = getDepth(root);
        int width = (1 << depth) - 1;
        for (int i = 0; i < depth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            res.add(list);
        }
        System.out.println(res);
        dfs(root , 0 , width , 0 , res);

        for (List<String> list : res){
            StringBuilder sb = new StringBuilder();
            for (String s : list){
                if (s.equals("")) sb.append("-");
                else sb.append(s);
            }
            System.out.println(sb.toString());
        }
        return res;
    }

    private static void dfs(TreeNode root, int l , int r , int height, List<List<String>> res) {
        if (root == null) return;
        int mid = l + r >> 1;
        res.get(height).set( mid, root.val + "");
        dfs(root.left , l , mid - 1, height + 1 , res);
        dfs(root.right , mid + 1, r  ,  height + 1 , res);
    }


    private static int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left) , getDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = getDefault();
        printTree(root);
    }
}
