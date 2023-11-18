package DataStructure.Hash._枚举两个变量的思路;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class _1010_num_pairs_divisible_60 {

    // 选举 2个元素的类型，类似于 two sum
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        // key 为 数字 % 60 ， value 为出现次数
        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < time.length ; i++){
            int cur = time[i] % 60;
            // 先查询map，再更新map，因为题目要求 i < j

            if(cur != 0) res += map.getOrDefault((60-cur) , 0);
            else res += map.getOrDefault(cur , 0);

            map.put(cur , map.getOrDefault(cur , 0)+1);
        }
        return res;


    }
}
