package DataStructure.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/array-nesting/
 * @date 2022/7/1711:26 AM
 */
public class array_nesting {

    // 数组嵌套,需要剪支优化
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        boolean[] isVisit = new boolean[nums.length];
        int res = 0;
        for (int num : nums) {
            // nums[i] 开头
            int a = num;
            while (!set.contains(a) && !isVisit[a]) {
                set.add(a);
                isVisit[a] = true;  // 这次循环里面出现的 数组中的元素，作为开头肯定也不会变成最大长度了
                a = nums[a];
            }
            res = Math.max(res, set.size());
            set.clear();
        }
        return res;
    }

    // 继续优化，可以不需要 哪个 visit 数组，直接将遍历过的元素改为 -1 就可以了

    public int arrayNesting2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0 ; i < nums.length ; i++){
            int cur = i , cnt = 0;
            while (nums[cur] != -1){
                cnt++;
                int c = cur;
                cur = nums[c];  // 遍历下一个数
                nums[c] = -1;   // 将当前数变成 -1
            }
            res = Math.max(res , cnt);
        }
        return res;
    }


}
