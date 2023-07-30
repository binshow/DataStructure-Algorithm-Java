package DataStructure.Array._哈希表;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/longest-consecutive-sequence/
public class _128最长连续序列 {

    // 输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int res = 0;
        for (int num : nums){
            int count = 1;
            if (set.contains(num)){
                int a = num + 1 , b = num-1;
                while (set.contains(a)) {
                    set.remove(a);
                    count++;
                    a++;
                }
                while (set.contains(b)) {
                    set.remove(b);
                    count++;
                    b--;
                }
            }
            res = Math.max(res , count);
        }
        return res;
    }
}
