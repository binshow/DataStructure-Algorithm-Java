package Array.sub_sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 * @date 2022/8/412:51 AM
 */
public class Minimum_Subsequence_in_Non_Increasing_Order {
    //https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
    // 最短子序列，而且不递增，且子序列和最大的
    public List<Integer> minSubsequence(int[] nums) {
        // 贪心算法，先排序，从后往前加
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        int cur = 0 , index = nums.length-1;
        while (cur <= sum){
            res.add(nums[index]);
            cur += nums[index];
            sum -= nums[index];
            index--;
        }
        return res;
    }
}
