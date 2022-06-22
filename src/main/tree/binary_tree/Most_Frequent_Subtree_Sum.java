package tree.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/most-frequent-subtree-sum/
 * @date 2022/6/1912:34 PM
 */
public class Most_Frequent_Subtree_Sum {

    // 出现次数最多的子树和
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        dfs(root);
        System.out.println(map);    // map 中 key为所有的子树和，value 为对应的出现的频次
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int num : map.keySet()){
            if(map.get(num) > count){
                count = map.get(num);
                list.clear();
                list.add(num);
            }else if (map.get(num) == count) list.add(num);
        }

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ;i++) res[i] = list.get(i);
        return res;

    }

    void dfs(TreeNode root){
        if(root == null) return;
        map.put( getTreeSum(root) , map.getOrDefault(getTreeSum(root) , 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }

    // 返回以root为根节点的二叉树所有节点之和
    int getTreeSum(TreeNode root){
        if(root == null) return 0;
        return root.val + getTreeSum(root.left) + getTreeSum(root.right);
    }
}
