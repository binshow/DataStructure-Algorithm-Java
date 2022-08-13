package Array.sub_sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/longest-increasing-subsequence/
 * @date 2022/8/412:46 AM
 */
public class Longest_Increasing_Subsequence {

    // 最长上升子序列
    //Input: nums = [10,9,2,5,3,7,101,18]
    //Output: 4
    //Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int res = 1;

        // dp[i] 表示以 nums[i]结尾的最长上升子序列
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                    res = Math.max(dp[i] , res); // dp 数组中的最大值就是 结果
                }
            }
        }
        return res;
    }

    // todo 如何求最长的上升子序列呢
    public List<Integer> lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return list;
    }

}
