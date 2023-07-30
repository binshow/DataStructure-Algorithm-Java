package DataStructure.Tree.q1_traversal;


// https://leetcode.cn/problems/print-binary-tree/

import java.util.ArrayList;
import java.util.List;

public class _655输出二叉树 {


    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;

        int depth = getDepth(root); // 高度
        int width = (1 << depth) - 1; // 宽度

        // 初始化
        for (int i = 0; i < depth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) list.add("");
            res.add(list);
        }

        // 插入二叉树
        dfs(root , res , 0 , 0 , width-1);

        // 打印二叉树
//        for (List<String> s : res){
//            StringBuilder sb = new StringBuilder();
//            for (String tem : s) {
//                if (tem.equals("")) sb.append(" ");
//                else sb.append(tem);
//            }
//            System.out.println(sb.toString());
//        }
        return res;
    }

    private void dfs(TreeNode root, List<List<String>> res, int height, int l, int r) {
        if (root == null) return;
        int mid = l + r >> 1;

        res.get(height).set(mid , root.val + "");
        dfs(root.left , res , height+1 , l  , mid-1);
        dfs(root.right , res , height+1 , mid+1  , r);
    }


    int getDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(getDepth(root.left) , getDepth(root.right)) + 1;
    }

}
