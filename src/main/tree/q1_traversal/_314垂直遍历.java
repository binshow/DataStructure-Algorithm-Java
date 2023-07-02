package tree.q1_traversal;

import java.util.*;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/298:57 AM
 */
public class _314垂直遍历 {

    //https://zhuanlan.zhihu.com/p/372100219
    // 垂直方向 每列的结果
    Map<Integer, List<Integer>> map = new HashMap();
    public List<Integer> verticalOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        queue.add(root);
        qIndex.add(0);

        while (queue.size() > 0 ){
            Map<Integer , List<Integer>> tmp = new HashMap<>();
            int n = queue.size();
            while ( n > 0 ){
                n--;
                TreeNode cur = queue.poll();
                int idx = qIndex.poll();

                if (tmp.containsKey(idx)) tmp.get(idx).add(cur.val);
                else tmp.put(idx , new ArrayList<>());

                if (cur.left != null){
                    queue.add(cur.left);
                    qIndex.add(idx-1);
                }

                if (cur.right != null){
                    queue.add(cur.right);
                    qIndex.add(idx+1);
                }
            }

            // step2: 对step1中的结果 排序
            // 因为垂直方向，底层的节点的值总比根节点的值小
            for(int key : tmp.keySet()){
                if(!map.containsKey(key)) map.put(key, new ArrayList<Integer>());
                List<Integer> list = tmp.get(key);

                // 每次将list中的值 从小到大排序
                // 因为垂直方向，底层的节点的值总比根节点的值小
                Collections.sort(list);
                map.get(key).addAll(list);
            }


        }



        return res;
    }

}
