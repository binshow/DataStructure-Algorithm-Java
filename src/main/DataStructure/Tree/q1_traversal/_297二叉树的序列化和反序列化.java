package DataStructure.Tree.q1_traversal;


// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class _297二叉树的序列化和反序列化 {


    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefault();
        System.out.println(serialize(root));
    }


    // Encodes a DataStructure.tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            TreeNode cur = queue.poll();
            if (cur != null){
                sb.append(cur.val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            }else sb.append("null,");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to DataStructure.tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] strs = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (queue.size() > 0){
            TreeNode cur = queue.poll();
            if (!strs[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.add(cur.left);
            }
            index++;
            if (!strs[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.add(cur.right);
            }
            index++;
        }
        return root;

    }


}
