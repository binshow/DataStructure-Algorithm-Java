package DataStructure.Tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static void printTree(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                count--;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(list);
        }
        for (List<Integer> list : res) System.out.println(list);
    }

    // Encodes a DataStructure.tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode != null){
                sb.append(curNode.val + ",");
                queue.add(curNode.left);
                queue.add(curNode.right);
            }else sb.append("null,");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to DataStructure.tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] nums = data.substring(1 , data.length()-1).split(",");
        // 先建立头节点
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(!nums[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nums[index]));
                queue.add(cur.left);
            }
            index++;
            if(!nums[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nums[index]));
                queue.add(cur.right);
            }
            index++;
        }
        return root;
    }



    public static void main(String[] args) {
        String data = "[1,2,3,null,null,4,5]";
        System.out.println(deserialize(data));
    }
}
