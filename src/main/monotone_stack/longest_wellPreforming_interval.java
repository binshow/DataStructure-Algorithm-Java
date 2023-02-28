package monotone_stack;


import java.util.*;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/longest-well-performing-interval/
 * @date 2023/2/141:05 PM
 */
public class longest_wellPreforming_interval {

    public static void main(String[] args) {
        int[] hours = {9,9,6,0,6,6,9};
        System.out.println(longestWPI(hours));
    }

    //Input: hours = [9,9,6,0,6,6,9]
    //Output: 3
    //Explanation: The longest well-performing interval is [9,9,6].

    // 思路：将劳累的一天记为1，不劳累的一天记为-1，问题变为：计算nums的最长子数组，其元素和大于0
    public static int longestWPI(int[] hours) {
        int n = hours.length;
        int res = 0;
        int gap = 0; // 表示下标0 到当前下标这一段的 差值，如果差值大于0，说明满足
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            gap += hours[i] > 8 ? 1 : -1;
            if (gap > 0){ // 满足条件
                res = i+1;
            }else if (map.containsKey(gap-1)){
                // map.get(gap-1) ~ i 这一段满足
                res = Math.max(res , i - map.get(gap-1));
            }
            map.putIfAbsent(gap , i); // 存放第一次存放的下标
        }
        return res;
    }
}
