package dp._打家劫舍问题;

import DataStructure.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _337打家劫舍v3 {
//   超时：
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//
//        // 偷root的
//        int res = root.val;
//        if (root.left != null) res += rob(root.left.left) + rob(root.left.right);
//        if (root.right != null) res += rob(root.right.left) + rob(root.right.right);
//
//        // 偷root 和 不偷root 的 取max
//        return Math.max(res , rob(root.left) + rob(root.right));
//    }



    // 上述容易超时，可以用记忆化搜索的方式
    Map<TreeNode , Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        // 偷root的
        int t1 = root.val;
        if (root.left != null) t1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) t1 += rob(root.right.left) + rob(root.right.right);

        // 偷root 和 不偷root 的 取max
        int t2 = rob(root.left) + rob(root.right);

        // 记录到map中
        int res = Math.max(t1 , t2);
        map.put(root , res);

        return res;
    }
}
